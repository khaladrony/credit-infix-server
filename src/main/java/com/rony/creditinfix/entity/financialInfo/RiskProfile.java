package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.RiskProfileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "risk_profile")
public class RiskProfile extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "status")
    private String status;

    public RiskProfile(RiskProfileDTO riskProfileDTO){
        this.setId(riskProfileDTO.getId());
        this.setVersion(riskProfileDTO.getVersion());
        this.setCompanyInfo(riskProfileDTO.getCompanyInfo());
        this.setItemCode(riskProfileDTO.getItemCode());
        this.setPercentage(riskProfileDTO.getPercentage());
        this.setStatus(riskProfileDTO.getStatus());
    }

}
