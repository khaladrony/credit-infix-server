package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail extends CommonColumn {
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

    public OrderDetail(OrderDetailDTO orderDetailDTO){
        this.setId(orderDetailDTO.getId());
        this.setVersion(orderDetailDTO.getVersion());
        this.setCompanyInfo(orderDetailDTO.getCompanyInfo());
        this.setItemCode(orderDetailDTO.getItemCode());
        this.setItemValue(orderDetailDTO.getItemValue());
    }

}
