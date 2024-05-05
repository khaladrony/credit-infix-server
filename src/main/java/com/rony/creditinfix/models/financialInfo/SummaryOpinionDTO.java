package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.SummaryOpinion;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryOpinionDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;

    public SummaryOpinionDTO(SummaryOpinion summaryOpinion) {
        this.setId(summaryOpinion.getId());
        this.setVersion(summaryOpinion.getVersion());
        this.setCompanyInfo(summaryOpinion.getCompanyInfo());
        this.setItemCode(summaryOpinion.getItemCode());
        this.setItemValue(summaryOpinion.getItemValue());
    }
}
