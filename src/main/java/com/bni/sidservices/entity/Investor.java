package com.bni.sidservices.entity;

import com.bni.sidservices.CheckSID;

import javax.persistence.*;

@Entity
@Table(name="ksei_fund_sep_account_ksei")
public class Investor{

    @Id
    @Column(name = "no_sid", unique = true, nullable = false)
    private String noSid;

    @Column(name = "bulk_file_upload_name")
    private String bulkFileUploadName;

    @Column(name = "no_sub_rek_efek")
    private String noSubRekEfek;

    @Column(name = "participantID")
    private String participantID;

    @Column(name = "accountNumberOnKsei")
    private String accountNumberOnKsei;

    @Column(name = "externalrefference")
    private String externalrefference;

    @Column(name = "ksei_investor_name")
    private String kseiInvestorName;

    @Column(name = "ksei_investor_id")
    private String kseiInvestorId;

    @Column(name = "ksei_investor_npwp")
    private String kseiInvestorNPWP;

    @Column(name = "ksei_investor_passport")
    private String kseiInvestorPassport;

    @Column(name = "ksei_ack_status")
    private String kseiAckStatus;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "parent_company_id")
    private String parentCompanyId;

    @Column(name = "request_uuid")
    private String requestUuid;

    public Investor(){
    }

    public Investor(String bulkFileUploadName, String participantID, String noSid, String accountNumberOnKsei, String externalrefference) {
        this.noSid = noSid;
        this.bulkFileUploadName = bulkFileUploadName;
        this.participantID = participantID;
        this.accountNumberOnKsei = accountNumberOnKsei;
        this.externalrefference = externalrefference;
    }

    public Investor(String companyId, String parentCompanyId, String requestUuid) {
        this.companyId = companyId;
        this.parentCompanyId = parentCompanyId;
        this.requestUuid = requestUuid;
    }

    public Investor(String noSid, String noSubRekEfek) {
        this.noSid = noSid;
        this.noSubRekEfek = noSubRekEfek;
    }

    public String getBulkFileUploadName() {
        return bulkFileUploadName;
    }

    public void setBulkFileUploadName(String bulkFileUploadName) {
        this.bulkFileUploadName = bulkFileUploadName;
    }

    public String getParticipantID() {
        return participantID;
    }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    public String getNoSid() {
        return noSid;
    }

    public void setNoSid(String noSid) {
        this.noSid = noSid;
    }

    public String getNoSubRekEfek() {
        return noSubRekEfek;
    }

    public void setNoSubRekEfek(String noSubRekEfek) {
        this.noSubRekEfek = noSubRekEfek;
    }

    public String getExternalrefference() {
        return externalrefference;
    }

    public void setExternalrefference(String externalrefference) {
        this.externalrefference = externalrefference;
    }

    public String getKseiInvestorName() {
        return kseiInvestorName;
    }

    public void setKseiInvestorName(String kseiInvestorName) {
        this.kseiInvestorName = kseiInvestorName;
    }

    public String getKseiInvestorId() {
        return kseiInvestorId;
    }

    public void setKseiInvestorId(String kseiInvestorId) {
        this.kseiInvestorId = kseiInvestorId;
    }

    public String getKseiInvestorNPWP() {
        return kseiInvestorNPWP;
    }

    public void setKseiInvestorNPWP(String kseiInvestorNPWP) {
        this.kseiInvestorNPWP = kseiInvestorNPWP;
    }

    public String getKseiInvestorPassport() {
        return kseiInvestorPassport;
    }

    public void setKseiInvestorPassport(String kseiInvestorPassport) {
        this.kseiInvestorPassport = kseiInvestorPassport;
    }

    public String getKseiAckStatus() {
        return kseiAckStatus;
    }

    public void setKseiAckStatus(String kseiAckStatus) {
        this.kseiAckStatus = kseiAckStatus;
    }
}
