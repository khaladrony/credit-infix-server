package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskLevelDTO extends CommonColumnDTO {
    private String category;
    private int startRange;
    private int endRange;
    private String remarks;

    public RiskLevelDTO(RiskLevel riskLevel){
        this.setId(riskLevel.getId());
        this.setVersion(riskLevel.getVersion());
        this.setCategory(riskLevel.getCategory());
        this.setStartRange(riskLevel.getStartRange());
        this.setEndRange(riskLevel.getEndRange());
        this.setRemarks(riskLevel.getRemarks());

    }
}
