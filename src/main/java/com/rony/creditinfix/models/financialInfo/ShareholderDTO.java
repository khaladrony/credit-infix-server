package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Shareholder;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareholderDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;
    private int sequence;

    public ShareholderDTO(Shareholder shareholder){
        this.setId(shareholder.getId());
        this.setVersion(shareholder.getVersion());
        this.setCompanyInfo(shareholder.getCompanyInfo());
        this.setItemCode(shareholder.getItemCode());
        this.setItemValue(shareholder.getItemValue());
        this.setSequence(shareholder.getSequence());
    }
}
