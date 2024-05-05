package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Bankers;
import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankersDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;
    private int sequence;

    public BankersDTO(Bankers bankers) {
        this.setId(bankers.getId());
        this.setVersion(bankers.getVersion());
        this.setCompanyInfo(bankers.getCompanyInfo());
        this.setItemCode(bankers.getItemCode());
        this.setItemValue(bankers.getItemValue());
        this.setSequence(bankers.getSequence());
    }
}
