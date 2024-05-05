package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoDTO extends CommonColumnDTO {
    private Date transactionDate;
    private String name;
    private String legalAddress;
    private String operationAddress;
    private String telephoneNumber;
    private String website;
    private String industryType;
    private String yearEstablished;
    private String ageOfBusiness;
    private String businessType;
    private String country;
    private String currency;
    private String businessScale;
    private String paymentPractices;
    private String listedStatus;
    private String status;
    private String numberOfDirector;
    private String numberOfShareholders;
    private String numberOfEmployee;
    private String numberOfSubsidiaries;
    private String holdingCompany;
    private String affiliatedCompanies;
    private String legalStatus;
    private String noOfCharge;
    private String noOfJudicialRecord;
    private String maximumCredit;
    private String creditRating;
    private String clientName;
    private String clientRefNo;
    private String infixRefNo;
    private String serviceType;
    private Date inquiryDate;
    private Date dueDate;
    private Date deliveryDate;
    private Date reportDate;
    private String productName;
    private Long createdBy;
    private Calendar createdAt;
    private Long updatedBy;
    private Calendar updatedAt;

    public CompanyInfoDTO(CompanyInfo companyInfo){
        this.setId(companyInfo.getId());
        this.setVersion(companyInfo.getVersion());
        this.setName(companyInfo.getName());
        this.setTransactionDate(companyInfo.getTransactionDate());
        this.setLegalAddress(companyInfo.getLegalAddress());
        this.setOperationAddress(companyInfo.getOperationAddress());
        this.setTelephoneNumber(companyInfo.getTelephoneNumber());
        this.setWebsite(companyInfo.getWebsite());
        this.setIndustryType(companyInfo.getIndustryType());
        this.setYearEstablished(companyInfo.getYearEstablished());
        this.setAgeOfBusiness(companyInfo.getAgeOfBusiness());
        this.setBusinessType(companyInfo.getBusinessType());
        this.setCountry(companyInfo.getCountry());
        this.setCurrency(companyInfo.getCurrency());
        this.setBusinessScale(companyInfo.getBusinessScale());
        this.setPaymentPractices(companyInfo.getPaymentPractices());
        this.setListedStatus(companyInfo.getListedStatus());
        this.setStatus(companyInfo.getStatus());
        this.setNumberOfDirector(companyInfo.getNumberOfDirector());
        this.setNumberOfShareholders(companyInfo.getNumberOfShareholders());
        this.setNumberOfEmployee(companyInfo.getNumberOfEmployee());
        this.setNumberOfSubsidiaries(companyInfo.getNumberOfSubsidiaries());
        this.setHoldingCompany(companyInfo.getHoldingCompany());
        this.setAffiliatedCompanies(companyInfo.getAffiliatedCompanies());
        this.setLegalStatus(companyInfo.getLegalStatus());
        this.setNoOfCharge(companyInfo.getNoOfCharge());
        this.setNoOfJudicialRecord(companyInfo.getNoOfJudicialRecord());
        this.setMaximumCredit(companyInfo.getMaximumCredit());
        this.setCreditRating(companyInfo.getCreditRating());
        this.setClientName(companyInfo.getClientName());
        this.setClientRefNo(companyInfo.getClientRefNo());
        this.setInfixRefNo(companyInfo.getInfixRefNo());
        this.setServiceType(companyInfo.getServiceType());
        this.setInquiryDate(companyInfo.getInquiryDate());
        this.setDueDate(companyInfo.getDueDate());
        this.setDeliveryDate(companyInfo.getDeliveryDate());
        this.setReportDate(companyInfo.getReportDate());
        this.setProductName(companyInfo.getProductName());
        this.setCreatedBy(companyInfo.getCreatedBy());
        this.setCreatedAt(companyInfo.getCreatedAt());
        this.setUpdatedBy(companyInfo.getUpdatedBy());
        this.setUpdatedAt(companyInfo.getUpdatedAt());
    }
}
