package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.RiskLevelDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "risk_level")
public class RiskLevel extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", length = 25)
    private String category;

    @Column(name = "start_range")
    private int startRange;

    @Column(name = "end_range")
    private int endRange;

    @Column(name = "remarks")
    private String remarks;

    public RiskLevel(RiskLevelDTO riskLevelDTO){
        this.setId(riskLevelDTO.getId());
        this.setCategory(riskLevelDTO.getCategory());
        this.setStartRange(riskLevelDTO.getStartRange());
        this.setEndRange(riskLevelDTO.getEndRange());
        this.setRemarks(riskLevelDTO.getRemarks());

    }
}
