package com.rony.creditinfix.services.storedProcedure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rony.creditinfix.entity.financialInfo.Bankers;
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
import com.rony.creditinfix.models.financialInfo.CompanyInfoDTO;
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
import com.rony.creditinfix.models.report.CompanyInfoReportGenerateDTO;
import com.rony.creditinfix.util.DateUtil;
import com.rony.creditinfix.util.General;
import com.rony.creditinfix.util.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CompanyInfoReportGenerateServiceImpl implements CompanyInfoReportGenerateService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    SpringSecurityUtil springSecurityUtil;


    @Override
    public CompanyInfoReportGenerateDTO execute(Long companyInfoId) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_company_info_report_data");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("companyInfoId", companyInfoId);

        CompanyInfoReportGenerateDTO dto = new CompanyInfoReportGenerateDTO();

        Map<String, Object> result = simpleJdbcCall.execute(in);

        // Extract data from result map
        CompanyInfoDTO companyInfo = mapToCompanyInfo((List<Map<String, Object>>) result.get("#result-set-1"));
        dto = setCompanyInfo(companyInfo);
        List<FinancialSummaryDTO> financialSummaries = mapToFinancialSummary((List<Map<String, Object>>) result.get("#result-set-2"));
        List<RiskProfileDTO> riskProfiles = mapToRiskProfile((List<Map<String, Object>>) result.get("#result-set-3"));
        List<OrderDetailDTO> orderDetail = mapToOrderDetail((List<Map<String, Object>>) result.get("#result-set-4"));
        List<ContactDTO> contact = mapToContact((List<Map<String, Object>>) result.get("#result-set-5"));
        List<LocationDTO> location = mapToLocation((List<Map<String, Object>>) result.get("#result-set-6"));
        List<RegistrationDetailDTO> registrationDetail = mapToRegistrationDetail((List<Map<String, Object>>) result.get("#result-set-7"));
        List<ManagementDTO> management = mapToManagement((List<Map<String, Object>>) result.get("#result-set-8"));
        List<ShareholderDTO> shareholder = mapToShareholder((List<Map<String, Object>>) result.get("#result-set-9"));
        List<OperationInfoDTO> operationInfo = mapToOperationInfo((List<Map<String, Object>>) result.get("#result-set-10"));
        List<NatureOfBusinessDTO> natureOfBusiness = mapToNatureOfBusiness((List<Map<String, Object>>) result.get("#result-set-11"));
        List<CorporateStructureDTO> corporateStructure = mapToCorporateStructure((List<Map<String, Object>>) result.get("#result-set-12"));
        List<BankersDTO> bankers = mapToBankers((List<Map<String, Object>>) result.get("#result-set-13"));
        List<FinancialInformationDTO> financialInformation = mapToFinancialInformation((List<Map<String, Object>>) result.get("#result-set-14"));
        List<SummaryOpinionDTO> summaryOpinion = mapToSummaryOpinion((List<Map<String, Object>>) result.get("#result-set-15"));

        dto.setFinancialSummary(financialSummaries);
        dto.setRiskProfile(riskProfiles);
        dto.setOrderDetail(orderDetail);
        dto.setContact(contact);
        dto.setLocation(location);
        dto.setRegistrationDetail(registrationDetail);
        dto.setManagement(management);
        dto.setShareholder(shareholder);
        dto.setOperationInfo(operationInfo);
        dto.setNatureOfBusiness(natureOfBusiness);
        dto.setCorporateStructure(corporateStructure);
        dto.setBankers(bankers);
        dto.setFinancialInformation(financialInformation);
        dto.setSummaryOpinion(summaryOpinion);

        return dto;
    }

    private CompanyInfoReportGenerateDTO setCompanyInfo(CompanyInfoDTO companyInfo) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(companyInfo);
            return General.getObjectMapperWithDifferentProperty(jsonString, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CompanyInfoDTO mapToCompanyInfo(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        Map<String, Object> row = resultSet.get(0);

        CompanyInfoDTO companyInfo = new CompanyInfoDTO();
//        companyInfo.setId((Long) row.get("id"));
        companyInfo.setName((String) row.get("name"));
        companyInfo.setTransactionDate(DateUtil.getDateFromLocalDateTime((LocalDateTime) row.get("transaction_date")));
        companyInfo.setLegalAddress((String) row.get("legal_address"));
        companyInfo.setOperationAddress((String) row.get("operation_address"));
        companyInfo.setTelephoneNumber((String) row.get("telephone_number"));
        companyInfo.setWebsite((String) row.get("website"));
        companyInfo.setIndustryType((String) row.get("industryType"));
        companyInfo.setYearEstablished((String) row.get("yearEstablished"));
        companyInfo.setAgeOfBusiness((String) row.get("ageOfBusiness"));
        companyInfo.setBusinessType((String) row.get("businessType"));
        companyInfo.setCountry((String) row.get("country"));
        companyInfo.setCurrency((String) row.get("currency"));
        companyInfo.setBusinessScale((String) row.get("businessScale"));
        companyInfo.setPaymentPractices((String) row.get("paymentPractices"));
        companyInfo.setListedStatus((String) row.get("listedStatus"));
        companyInfo.setStatus((String) row.get("status"));
        companyInfo.setNumberOfDirector((String) row.get("numberOfDirector"));
        companyInfo.setNumberOfShareholders((String) row.get("numberOfShareholders"));
        companyInfo.setNumberOfEmployee((String) row.get("numberOfEmployee"));
        companyInfo.setNumberOfSubsidiaries((String) row.get("numberOfSubsidiaries"));
        companyInfo.setHoldingCompany((String) row.get("holdingCompany"));
        companyInfo.setAffiliatedCompanies((String) row.get("affiliatedCompanies"));
        companyInfo.setLegalStatus((String) row.get("legalStatus"));
        companyInfo.setNoOfCharge((String) row.get("noOfCharge"));
        companyInfo.setNoOfJudicialRecord((String) row.get("noOfJudicialRecord"));
        companyInfo.setMaximumCredit((String) row.get("maximumCredit"));
        companyInfo.setCreditRating((String) row.get("creditRating"));
        companyInfo.setCreatedBy((Long) row.get("createdBy"));

        return companyInfo;
    }

    private List<FinancialSummaryDTO> mapToFinancialSummary(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<FinancialSummaryDTO> FinancialSummaries = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            FinancialSummaryDTO financialSummary = new FinancialSummaryDTO();
            financialSummary.setItemCode((String) row.get("item_code"));
            financialSummary.setCurrency((String) row.get("currency"));
            financialSummary.setAmount((String) row.get("amount"));
            financialSummary.setComments((String) row.get("comments"));

            FinancialSummaries.add(financialSummary);
        }

        return FinancialSummaries;
    }

    private List<RiskProfileDTO> mapToRiskProfile(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<RiskProfileDTO> riskProfiles = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            RiskProfileDTO riskProfile = new RiskProfileDTO();
            riskProfile.setItemCode((String) row.get("item_code"));
            riskProfile.setPercentage((int) row.get("percentage"));
            riskProfile.setStatus((String) row.get("status"));

            riskProfiles.add(riskProfile);
        }

        return riskProfiles;
    }

    private List<OrderDetailDTO> mapToOrderDetail(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<OrderDetailDTO> orderDetails = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            OrderDetailDTO orderDetail = new OrderDetailDTO();
            orderDetail.setItemCode((String) row.get("item_code"));
            orderDetail.setItemValue((String) row.get("item_value"));

            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }

    private List<ContactDTO> mapToContact(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<ContactDTO> contacts = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            ContactDTO contact = new ContactDTO();
            contact.setTelephoneNo((String) row.get("telephone_no"));
            contact.setFaxNo((String) row.get("fax_no"));
            contact.setEmail((String) row.get("email"));
            contact.setWebsite((String) row.get("website"));

            contacts.add(contact);
        }
        return contacts;
    }

    private List<LocationDTO> mapToLocation(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<LocationDTO> locations = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            LocationDTO location = new LocationDTO();
            location.setItemCode((String) row.get("item_code"));
            location.setItemValue((String) row.get("item_value"));

            locations.add(location);
        }
        return locations;
    }

    private List<RegistrationDetailDTO> mapToRegistrationDetail(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<RegistrationDetailDTO> registrationDetails = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            RegistrationDetailDTO registrationDetail = new RegistrationDetailDTO();
            registrationDetail.setItem((String) row.get("item"));
            registrationDetail.setSubItem((String) row.get("sub_item"));
            registrationDetail.setItemValue((String) row.get("item_value"));
            registrationDetail.setRowSpan((boolean) row.get("is_row_span"));
            registrationDetail.setColSpan((boolean) row.get("is_col_span"));
            registrationDetail.setSequence((int) row.get("sequence"));

            registrationDetails.add(registrationDetail);
        }
        return registrationDetails;
    }

    private List<ManagementDTO> mapToManagement(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<ManagementDTO> managements = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            ManagementDTO management = new ManagementDTO();
            management.setItemCode((String) row.get("item_code"));
            management.setItemValue((String) row.get("item_value"));
            management.setSequence((int) row.get("sequence"));

            managements.add(management);
        }
        return managements;
    }

    private List<ShareholderDTO> mapToShareholder(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<ShareholderDTO> shareholders = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            ShareholderDTO shareholder = new ShareholderDTO();
            shareholder.setItemCode((String) row.get("item_code"));
            shareholder.setItemValue((String) row.get("item_value"));
            shareholder.setSequence((int) row.get("sequence"));

            shareholders.add(shareholder);
        }
        return shareholders;
    }

    private List<OperationInfoDTO> mapToOperationInfo(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<OperationInfoDTO> operationInfos = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            OperationInfoDTO operationInfo = new OperationInfoDTO();
            operationInfo.setItemCode((String) row.get("item_code"));
            operationInfo.setItemValue((String) row.get("item_value"));
            operationInfo.setSequence((int) row.get("sequence"));

            operationInfos.add(operationInfo);
        }
        return operationInfos;
    }

    private List<NatureOfBusinessDTO> mapToNatureOfBusiness(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<NatureOfBusinessDTO> natureOfBusinesses = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            NatureOfBusinessDTO natureOfBusiness = new NatureOfBusinessDTO();
            natureOfBusiness.setItemCode((String) row.get("item_code"));
            natureOfBusiness.setItemValue((String) row.get("item_value"));

            natureOfBusinesses.add(natureOfBusiness);
        }
        return natureOfBusinesses;
    }
    private List<CorporateStructureDTO> mapToCorporateStructure(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<CorporateStructureDTO> corporateStructures = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            CorporateStructureDTO corporateStructure = new CorporateStructureDTO();
            corporateStructure.setItemCode((String) row.get("item_code"));
            corporateStructure.setItemValue((String) row.get("item_value"));
            corporateStructure.setSequence((int) row.get("sequence"));

            corporateStructures.add(corporateStructure);
        }
        return corporateStructures;
    }
    private List<BankersDTO> mapToBankers(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }
        List<BankersDTO> bankers = new ArrayList<>();
        for (Map<String, Object> row : resultSet) {
            BankersDTO bankerObj = new BankersDTO();
            bankerObj.setItemCode((String) row.get("item_code"));
            bankerObj.setItemValue((String) row.get("item_value"));
            bankerObj.setSequence((int) row.get("sequence"));

            bankers.add(bankerObj);
        }
        return bankers;
    }
    private List<FinancialInformationDTO> mapToFinancialInformation(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }

        List<FinancialInformationDTO> financialInformations = new ArrayList<>();

        for (Map<String, Object> row : resultSet) {
            FinancialInformationDTO financialInformation = new FinancialInformationDTO();
            financialInformation.setItemCode((String) row.get("item_code"));
            financialInformation.setThirdYear((String) row.get("third_year"));
            financialInformation.setSecondYear((String) row.get("second_year"));
            financialInformation.setFirstYear((String) row.get("first_year"));
            financialInformation.setHtmlType((String) row.get("html_type"));

            financialInformations.add(financialInformation);
        }
        return financialInformations;
    }
    private List<SummaryOpinionDTO> mapToSummaryOpinion(List<Map<String, Object>> resultSet) {
        if (resultSet == null || resultSet.isEmpty()) {
            return null;
        }
        List<SummaryOpinionDTO> summaryOpinions = new ArrayList<>();
        for (Map<String, Object> row : resultSet) {
            SummaryOpinionDTO summaryOpinion = new SummaryOpinionDTO();
            summaryOpinion.setItemCode((String) row.get("item_code"));
            summaryOpinion.setItemValue((String) row.get("item_value"));

            summaryOpinions.add(summaryOpinion);
        }
        return summaryOpinions;
    }
}
