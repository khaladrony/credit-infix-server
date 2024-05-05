package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialSummaryDTO  extends CommonColumnDTO {
    private String itemCode;
    private String currency;
    private String amount;
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
