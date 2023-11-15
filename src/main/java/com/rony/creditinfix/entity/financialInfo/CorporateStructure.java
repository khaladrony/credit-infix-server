package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.CorporateStructureDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "corporate_structure")
public class CorporateStructure extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_value", length = 1000)
    private String itemValue;

    @Column(name = "sequence")
    private int sequence;

    public CorporateStructure(CorporateStructureDTO corporateStructureDTO) {
        this.setId(corporateStructureDTO.getId());
        this.setVersion(corporateStructureDTO.getVersion());
        this.setCompanyInfo(corporateStructureDTO.getCompanyInfo());
        this.setItemCode(corporateStructureDTO.getItemCode());
        this.setItemValue(corporateStructureDTO.getItemValue());
        this.setSequence(corporateStructureDTO.getSequence());
    }
}
