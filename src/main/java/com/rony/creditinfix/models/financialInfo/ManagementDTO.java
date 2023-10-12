package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.Management;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagementDTO {
    private Long id;
    private int version;

    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;
    private int sequence;


    public ManagementDTO(Management management){
        this.setId(management.getId());
        this.setVersion(management.getVersion());
        this.setCompanyInfo(management.getCompanyInfo());
        this.setItemCode(management.getItemCode());
        this.setItemValue(management.getItemValue());
        this.setSequence(management.getSequence());
    }
}
