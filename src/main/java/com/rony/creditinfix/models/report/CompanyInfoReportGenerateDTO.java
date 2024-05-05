package com.rony.creditinfix.models.report;

import com.rony.creditinfix.entity.financialInfo.Bankers;
import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Contact;
import com.rony.creditinfix.entity.financialInfo.CorporateStructure;
import com.rony.creditinfix.entity.financialInfo.FinancialInformation;
import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import com.rony.creditinfix.entity.financialInfo.Location;
import com.rony.creditinfix.entity.financialInfo.Management;
import com.rony.creditinfix.entity.financialInfo.NatureOfBusiness;
import com.rony.creditinfix.entity.financialInfo.OperationInfo;
import com.rony.creditinfix.entity.financialInfo.OrderDetail;
import com.rony.creditinfix.entity.financialInfo.RegistrationDetail;
import com.rony.creditinfix.entity.financialInfo.RiskProfile;
import com.rony.creditinfix.entity.financialInfo.Shareholder;
import com.rony.creditinfix.entity.financialInfo.SummaryOpinion;
import com.rony.creditinfix.models.financialInfo.BankersDTO;
import com.rony.creditinfix.models.financialInfo.ContactDTO;
import com.rony.creditinfix.models.financialInfo.CorporateStructureDTO;
import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import com.rony.creditinfix.models.financialInfo.LocationDTO;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.models.financialInfo.NatureOfBusinessDTO;
import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import com.rony.creditinfix.models.financialInfo.RiskProfileDTO;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import com.rony.creditinfix.models.financialInfo.SummaryOpinionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Data
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
public class CompanyInfoReportGenerateDTO {
    private Long id;
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
    private Long createdBy;

    @XmlElementWrapper(name = "financialSummary")
    @XmlElement(name = "data")
    private List<FinancialSummaryDTO> financialSummary;

    @XmlElementWrapper(name = "riskProfile")
    @XmlElement(name = "data")
    private List<RiskProfileDTO> riskProfile;

    @XmlElementWrapper(name = "orderDetail")
    @XmlElement(name = "data")
    private List<OrderDetailDTO> orderDetail;

    @XmlElementWrapper(name = "contact")
    @XmlElement(name = "data")
    private List<ContactDTO> contact;

    @XmlElementWrapper(name = "location")
    @XmlElement(name = "data")
    private List<LocationDTO> location;

    @XmlElementWrapper(name = "registrationDetail")
    @XmlElement(name = "data")
    private List<RegistrationDetailDTO> registrationDetail;

    @XmlElementWrapper(name = "management")
    @XmlElement(name = "data")
    private List<ManagementDTO> management;

    @XmlElementWrapper(name = "shareholder")
    @XmlElement(name = "data")
    private List<ShareholderDTO> shareholder;

    @XmlElementWrapper(name = "operationInfo")
    @XmlElement(name = "data")
    private List<OperationInfoDTO> operationInfo;

    @XmlElementWrapper(name = "natureOfBusiness")
    @XmlElement(name = "data")
    private List<NatureOfBusinessDTO> natureOfBusiness;

    @XmlElementWrapper(name = "corporateStructure")
    @XmlElement(name = "data")
    private List<CorporateStructureDTO> corporateStructure;

    @XmlElementWrapper(name = "bankers")
    @XmlElement(name = "data")
    private List<BankersDTO> bankers;

    @XmlElementWrapper(name = "financialInformation")
    @XmlElement(name = "data")
    private List<FinancialInformationDTO> financialInformation;

    @XmlElementWrapper(name = "summaryOpinion")
    @XmlElement(name = "data")
    private List<SummaryOpinionDTO> summaryOpinion;
}
