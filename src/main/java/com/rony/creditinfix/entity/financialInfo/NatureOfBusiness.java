package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.NatureOfBusinessDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nature_of_business")
public class NatureOfBusiness extends CommonColumn {

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

    public NatureOfBusiness(NatureOfBusinessDTO natureOfBusinessDTO){
        this.setId(natureOfBusinessDTO.getId());
        this.setVersion(natureOfBusinessDTO.getVersion());
        this.setCompanyInfo(natureOfBusinessDTO.getCompanyInfo());
        this.setItemCode(natureOfBusinessDTO.getItemCode());
        this.setItemValue(natureOfBusinessDTO.getItemValue());
    }
}
