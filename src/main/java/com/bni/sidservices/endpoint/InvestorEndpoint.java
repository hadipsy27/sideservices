package com.bni.sidservices.endpoint;

import com.bni.sidservices.*;
import com.bni.sidservices.entity.Investor;
import com.bni.sidservices.service.InvestorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Endpoint
public class InvestorEndpoint {

    public static final String NAMESPACE_URI = "http://spring.io/guides/ns1-producing-web-service";

    @Autowired
    InvestorService service;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CheckSID")
    @ResponsePayload
    public CheckSIDResponse addInvestor(@RequestPayload CheckSID request) {
        CheckSIDResponse response = new CheckSIDResponse();
        CheckSIDRes checkSIDRes = new CheckSIDRes();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyy_hhmmss");
        LocalDateTime now = LocalDateTime.now();
        String externalReff  = "FSVDIBNI02" + dtf.format(now);
        Investor newInvestor = new Investor(request.getBulkFileUploadName(), request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getParticipantID(), request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getSidNumber(), request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getAccountNumberOnKsei(), externalReff);
        Investor saveInvestor = service.addInvestor(newInvestor);

        CheckSIDRes newCheckSIDRes = new CheckSIDRes();
        response.setFilename("");
        FundSeparationDataSIDDetails fundSeparationDataSIDDetails= new FundSeparationDataSIDDetails();
        fundSeparationDataSIDDetails.setParticipantID(request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getParticipantID());
        fundSeparationDataSIDDetails.setSidNumber(request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getSidNumber());
        fundSeparationDataSIDDetails.setAccountNumberOnKsei(request.getFundSeparationDataSID().getFundSeparationDataSIDDetails().getAccountNumberOnKsei());
        fundSeparationDataSIDDetails.setExternalReff("FSVDIBNI02" + dtf.format(now));
        newCheckSIDRes.setFundSeparationDataSIDResDetails(fundSeparationDataSIDDetails);
        BeanUtils.copyProperties(newInvestor, newCheckSIDRes);
        response.setCheckSIDRes(newCheckSIDRes);
        //response.setServiceStatus(serviceStatus);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CheckSIDAck")
    @ResponsePayload
    public CheckSIDAckResponse checkSIDAckResponse(@RequestPayload CheckSIDAck request) throws Exception{
        return service.checkSidAckResponse(request);
    }

}
