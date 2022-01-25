package com.bni.sidservices.service;

import com.bni.sidservices.CheckSIDAck;
import com.bni.sidservices.CheckSIDAckResponse;
import com.bni.sidservices.InvestorInfo;
import com.bni.sidservices.entity.Investor;
import com.bni.sidservices.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    InvestorRepository investorRepository;

    @Override
    public Investor addInvestor(Investor investor) {
        
        List<Investor> investors = investorRepository.findByNoId(investor.getNoSid());

        for (Investor i : investors) {
            if (i.getKseiAckStatus() == null) {
                return investorRepository.save(investor);
            } else if (i.getKseiAckStatus() != null) {
                System.out.println("Cannot insert data");
            }
        }

        return investor;

    }

    @Override
    public CheckSIDAckResponse checkSidAckResponse(CheckSIDAck request) throws Exception {

        String noSid = request.getRequest().getSid();
        String noSubRekEfek = request.getRequest().getSre();
        CheckSIDAckResponse response = new CheckSIDAckResponse();
        List<Investor> investor = investorRepository.findByNoSid(noSid, noSubRekEfek);
        for (int i = 0; i < investor.size(); i++) {
            Investor investor1 = investor.get(i);
            if (noSid.equals(investor1.getNoSid()) && noSubRekEfek.equals(investor1.getNoSubRekEfek())) {
                response.setExternalrefference(investor1.getExternalrefference());
                response.setKseiInvestorName(investor1.getKseiInvestorName());
                response.setKseiInvestorId(investor1.getKseiInvestorId());
                response.setKseiInvestorNPWP(investor1.getKseiInvestorNPWP());
                response.setKseiInvestorPassport(investor1.getKseiInvestorPassport());
                response.setKseiAckStatus(investor1.getKseiAckStatus());
            }
        }
        return response;
    }

//    @Override
//    public Investor getInvestorById(String noSid, String noSubRekEfek){
//        Investor investor = investorRepository.findById(noSid).get();
//        investor.setExternalrefference(investor.getExternalrefference());
//        investor.setKseiInvestorName(investor.getKseiInvestorName());
//        investor.setKseiInvestorNPWP(investor.getKseiInvestorNPWP());
//        investor.setKseiInvestorPassport(investor.getKseiInvestorPassport());
//        investor.setKseiAckStatus(investor.getKseiAckStatus());
//        return investor;
//    }
}
