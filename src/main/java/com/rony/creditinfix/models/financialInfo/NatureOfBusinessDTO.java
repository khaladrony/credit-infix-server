package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.NatureOfBusiness;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NatureOfBusinessDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;

    public NatureOfBusinessDTO(NatureOfBusiness natureOfBusiness){
        this.setId(natureOfBusiness.getId());
        this.setVersion(natureOfBusiness.getVersion());
        this.setCompanyInfo(natureOfBusiness.getCompanyInfo());
        this.setItemCode(natureOfBusiness.getItemCode());
        this.setItemValue(natureOfBusiness.getItemValue());
    }
}
