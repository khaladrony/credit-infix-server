package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialSummaryDTO {

    private Long id;
    private int version;
    private String itemCode;
    private String currency;
    private double amount;
    private String comments;
    private CompanyInfo companyInfo;

    public FinancialSummaryDTO(FinancialSummary financialSummary){
        this.setId(financialSummary.getId());
        this.setVersion(financialSummary.getVersion());
        this.setCompanyInfo(financialSummary.getCompanyInfo());
        this.setItemCode(financialSummary.getItemCode());
        this.setCurrency(financialSummary.getCurrency());
        this.setAmount(financialSummary.getAmount());
        this.setComments(financialSummary.getComments());
    }
}
