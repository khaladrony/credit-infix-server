package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "operation_info")
public class OperationInfo  extends CommonColumn {

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

    public OperationInfo(OperationInfoDTO operationInfoDTO){
        this.setId(operationInfoDTO.getId());
        this.setVersion(operationInfoDTO.getVersion());
        this.setCompanyInfo(operationInfoDTO.getCompanyInfo());
        this.setItemCode(operationInfoDTO.getItemCode());
        this.setItemValue(operationInfoDTO.getItemValue());
    }
}
