package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "registration_detail")
public class RegistrationDetail extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item")
    private String item;

    @Column(name = "sub_item")
    private String subItem;

    @Column(name = "item_value")
    private String itemValue;

    @Column(name = "is_row_span")
    private boolean isRowSpan;

    @Column(name = "is_col_span")
    private boolean isColSpan;

    public RegistrationDetail(RegistrationDetailDTO registrationDetailDTO){
        this.setId(registrationDetailDTO.getId());
        this.setVersion(registrationDetailDTO.getVersion());
        this.setCompanyInfo(registrationDetailDTO.getCompanyInfo());
        this.setItem(registrationDetailDTO.getItem());
        this.setSubItem(registrationDetailDTO.getSubItem());
        this.setItemValue(registrationDetailDTO.getItemValue());
        this.setRowSpan(registrationDetailDTO.isRowSpan());
        this.setColSpan(registrationDetailDTO.isColSpan());

    }
}
