package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shareholder")
public class Shareholder extends CommonColumn {

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

    public Shareholder(ShareholderDTO shareholderDTO){
        this.setId(shareholderDTO.getId());
        this.setVersion(shareholderDTO.getVersion());
        this.setCompanyInfo(shareholderDTO.getCompanyInfo());
        this.setItemCode(shareholderDTO.getItemCode());
        this.setItemValue(shareholderDTO.getItemValue());
        this.setSequence(shareholderDTO.getSequence());
    }
}
