package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskLevelDTO {
    private Long id;
    private String category;
    private int startRange;
    private int endRange;
    private String remarks;

    public RiskLevelDTO(RiskLevel riskLevel){
        this.setId(riskLevel.getId());
        this.setCategory(riskLevel.getCategory());
        this.setStartRange(riskLevel.getStartRange());
        this.setEndRange(riskLevel.getEndRange());
        this.setRemarks(riskLevel.getRemarks());

    }
}
