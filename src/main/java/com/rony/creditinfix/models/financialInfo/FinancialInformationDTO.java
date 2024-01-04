package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.FinancialInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialInformationDTO {

    private Long id;
    private int version;

    private CompanyInfo companyInfo;
    private String itemCode;
    private String thirdYear;
    private String secondYear;
    private String firstYear;
    private String htmlType;

    public FinancialInformationDTO(FinancialInformation financialInformation) {
        this.setId(financialInformation.getId());
        this.setVersion(financialInformation.getVersion());
        this.setCompanyInfo(financialInformation.getCompanyInfo());
        this.setItemCode(financialInformation.getItemCode());
        this.setThirdYear(financialInformation.getThirdYear());
        this.setSecondYear(financialInformation.getSecondYear());
        this.setFirstYear(financialInformation.getFirstYear());
        this.setHtmlType(financialInformation.getHtmlType());
    }

}
