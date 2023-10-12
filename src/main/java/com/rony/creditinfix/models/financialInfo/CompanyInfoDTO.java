package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoDTO {
    private Long id;
    private int version;
    private String name;
    private String legalAddress;
    private String operationAddress;
    private String telephoneNumber;
    private String website;
//    private String faxNo;
//    private String email;
    private String industryType;
    private String yearEstablished;
    private String ageOfBusiness;
    private String businessType;
    private String country;
//    private String state;
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

    public CompanyInfoDTO(CompanyInfo companyInfo){
        this.setId(companyInfo.getId());
        this.setVersion(companyInfo.getVersion());
        this.setName(companyInfo.getName());
        this.setLegalAddress(companyInfo.getLegalAddress());
        this.setOperationAddress(companyInfo.getOperationAddress());
        this.setTelephoneNumber(companyInfo.getTelephoneNumber());
        this.setWebsite(companyInfo.getWebsite());
        this.setIndustryType(companyInfo.getIndustryType());
        this.setYearEstablished(companyInfo.getYearEstablished());
        this.setAgeOfBusiness(companyInfo.getAgeOfBusiness());
        this.setBusinessType(companyInfo.getBusinessType());
        this.setCountry(companyInfo.getCountry());
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
    }
}
