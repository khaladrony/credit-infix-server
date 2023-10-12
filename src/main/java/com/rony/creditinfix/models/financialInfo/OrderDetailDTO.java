package com.rony.creditinfix.models.financialInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {

    private Long id;
    private int version;
    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;

    public OrderDetailDTO(OrderDetail orderDetail){
        this.setId(orderDetail.getId());
        this.setVersion(orderDetail.getVersion());
        this.setCompanyInfo(orderDetail.getCompanyInfo());
        this.setItemCode(orderDetail.getItemCode());
        this.setItemValue(orderDetail.getItemValue());
    }
}
