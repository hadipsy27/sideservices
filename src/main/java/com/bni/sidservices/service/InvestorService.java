package com.bni.sidservices.service;

import com.bni.sidservices.CheckSIDAck;
import com.bni.sidservices.CheckSIDAckResponse;
import com.bni.sidservices.InvestorInfo;
import com.bni.sidservices.entity.Investor;

import java.util.List;

public interface InvestorService {
    public Investor addInvestor(Investor investor);
    CheckSIDAckResponse checkSidAckResponse (CheckSIDAck request) throws Exception;
}
