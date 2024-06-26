package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.CorporateStructure;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorporateStructureDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;
    private int sequence;

    public CorporateStructureDTO(CorporateStructure corporateStructure) {
        this.setId(corporateStructure.getId());
        this.setVersion(corporateStructure.getVersion());
        this.setCompanyInfo(corporateStructure.getCompanyInfo());
        this.setItemCode(corporateStructure.getItemCode());
        this.setItemValue(corporateStructure.getItemValue());
        this.setSequence(corporateStructure.getSequence());
    }
}