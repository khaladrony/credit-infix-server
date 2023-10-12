package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "management")
public class Management extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_value")
    private String itemValue;

    @Column(name = "sequence")
    private int sequence;

    public Management(ManagementDTO managementDTO){
        this.setId(managementDTO.getId());
        this.setVersion(managementDTO.getVersion());
        this.setCompanyInfo(managementDTO.getCompanyInfo());
        this.setItemCode(managementDTO.getItemCode());
        this.setItemValue(managementDTO.getItemValue());
        this.setSequence(managementDTO.getSequence());
    }
}
