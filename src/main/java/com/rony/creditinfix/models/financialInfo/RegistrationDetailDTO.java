package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.RegistrationDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDetailDTO {

    private Long id;
    private int version;
    private CompanyInfo companyInfo;
    private String item;
    private String subItem;
    private String itemValue;
    private boolean isRowSpan;
    private boolean isColSpan;

    public RegistrationDetailDTO(RegistrationDetail registrationDetail){
        this.setId(registrationDetail.getId());
        this.setVersion(registrationDetail.getVersion());
        this.setCompanyInfo(registrationDetail.getCompanyInfo());
        this.setItem(registrationDetail.getItem());
        this.setSubItem(registrationDetail.getSubItem());
        this.setItemValue(registrationDetail.getItemValue());
        this.setRowSpan(registrationDetail.isRowSpan());
        this.setColSpan(registrationDetail.isColSpan());

    }
}
