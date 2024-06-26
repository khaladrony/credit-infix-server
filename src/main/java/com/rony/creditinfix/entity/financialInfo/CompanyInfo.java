package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.CompanyInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company_info")
public class CompanyInfo extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "operation_address")
    private String operationAddress;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "website")
    private String website;

    @Column(name = "industry_type")
    private String industryType;

    @Column(name = "year_established")
    private String yearEstablished;

    @Column(name = "age_Of_business")
    private String ageOfBusiness;

    @Column(name = "business_type")
    private String businessType;

    @Column(name = "country")
    private String country;

    @Column(name = "currency")
    private String currency;

    @Column(name = "business_scale")
    private String businessScale;

    @Column(name = "payment_practices")
    private String paymentPractices;

    @Column(name = "listed_status")
    private String listedStatus;

    @Column(name = "status")
    private String status;


    @Column(name = "number_of_director")
    private String numberOfDirector;

    @Column(name = "number_of_Shareholders")
    private String numberOfShareholders;

    @Column(name = "number_of_employee")
    private String numberOfEmployee;

    @Column(name = "number_of_subsidiaries")
    private String numberOfSubsidiaries;

    @Column(name = "holding_company")
    private String holdingCompany;

    @Column(name = "affiliated_companies")
    private String affiliatedCompanies;

    @Column(name = "legal_status")
    private String legalStatus;

    @Column(name = "no_of_charge")
    private String noOfCharge;

    @Column(name = "no_of_judicial_record")
    private String noOfJudicialRecord;

    @Column(name = "maximum_credit")
    private String maximumCredit;

    @Column(name = "credit_rating")
    private String creditRating;

    //Basic info
    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_ref_no")
    private String clientRefNo;

    @Column(name = "infix_ref_no")
    private String infixRefNo;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "inquiry_date")
    private Date inquiryDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "product_name")
    private String productName;

    public CompanyInfo(CompanyInfoDTO companyInfoDTO){
        this.setId(companyInfoDTO.getId());
        this.setVersion(companyInfoDTO.getVersion());
        this.setName(companyInfoDTO.getName());
        this.setTransactionDate(companyInfoDTO.getTransactionDate());
        this.setLegalAddress(companyInfoDTO.getLegalAddress());
        this.setOperationAddress(companyInfoDTO.getOperationAddress());
        this.setTelephoneNumber(companyInfoDTO.getTelephoneNumber());
        this.setWebsite(companyInfoDTO.getWebsite());
        this.setIndustryType(companyInfoDTO.getIndustryType());
        this.setYearEstablished(companyInfoDTO.getYearEstablished());
        this.setAgeOfBusiness(companyInfoDTO.getAgeOfBusiness());
        this.setBusinessType(companyInfoDTO.getBusinessType());
        this.setCountry(companyInfoDTO.getCountry());
        this.setCurrency(companyInfoDTO.getCurrency());
        this.setBusinessScale(companyInfoDTO.getBusinessScale());
        this.setPaymentPractices(companyInfoDTO.getPaymentPractices());
        this.setListedStatus(companyInfoDTO.getListedStatus());
        this.setStatus(companyInfoDTO.getStatus());
        this.setNumberOfDirector(companyInfoDTO.getNumberOfDirector());
        this.setNumberOfShareholders(companyInfoDTO.getNumberOfShareholders());
        this.setNumberOfEmployee(companyInfoDTO.getNumberOfEmployee());
        this.setNumberOfSubsidiaries(companyInfoDTO.getNumberOfSubsidiaries());
        this.setHoldingCompany(companyInfoDTO.getHoldingCompany());
        this.setAffiliatedCompanies(companyInfoDTO.getAffiliatedCompanies());
        this.setLegalStatus(companyInfoDTO.getLegalStatus());
        this.setNoOfCharge(companyInfoDTO.getNoOfCharge());
        this.setNoOfJudicialRecord(companyInfoDTO.getNoOfJudicialRecord());
        this.setMaximumCredit(companyInfoDTO.getMaximumCredit());
        this.setCreditRating(companyInfoDTO.getCreditRating());
        this.setClientName(companyInfoDTO.getClientName());
        this.setClientRefNo(companyInfoDTO.getClientRefNo());
        this.setInfixRefNo(companyInfoDTO.getInfixRefNo());
        this.setServiceType(companyInfoDTO.getServiceType());
        this.setInquiryDate(companyInfoDTO.getInquiryDate());
        this.setDueDate(companyInfoDTO.getDueDate());
        this.setDeliveryDate(companyInfoDTO.getDeliveryDate());
        this.setReportDate(companyInfoDTO.getReportDate());
        this.setProductName(companyInfoDTO.getProductName());
        this.setCreatedBy(companyInfoDTO.getCreatedBy());
        this.setCreatedAt(companyInfoDTO.getCreatedAt());
        this.setUpdatedBy(companyInfoDTO.getUpdatedBy());
        this.setUpdatedAt(companyInfoDTO.getUpdatedAt());
    }
}
