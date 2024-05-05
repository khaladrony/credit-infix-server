package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.RiskProfile;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskProfileDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private int percentage;
    private String status;

    public RiskProfileDTO(RiskProfile riskProfile){
        this.setId(riskProfile.getId());
        this.setVersion(riskProfile.getVersion());
        this.setCompanyInfo(riskProfile.getCompanyInfo());
        this.setItemCode(riskProfile.getItemCode());
        this.setPercentage(riskProfile.getPercentage());
        this.setStatus(riskProfile.getStatus());
    }
}
