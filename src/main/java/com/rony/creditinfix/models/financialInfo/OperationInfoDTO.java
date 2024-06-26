package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.OperationInfo;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationInfoDTO extends CommonColumnDTO {
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;
    private int sequence;

    public OperationInfoDTO(OperationInfo operationInfo){
        this.setId(operationInfo.getId());
        this.setVersion(operationInfo.getVersion());
        this.setCompanyInfo(operationInfo.getCompanyInfo());
        this.setItemCode(operationInfo.getItemCode());
        this.setItemValue(operationInfo.getItemValue());
        this.setSequence(operationInfo.getSequence());
    }
}
