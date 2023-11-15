package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.BankersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bankers")
public class Bankers extends CommonColumn {

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

    @Column(name = "sequence")
    private int sequence;

    public Bankers(BankersDTO bankersDTO){
        this.setId(bankersDTO.getId());
        this.setVersion(bankersDTO.getVersion());
        this.setCompanyInfo(bankersDTO.getCompanyInfo());
        this.setItemCode(bankersDTO.getItemCode());
        this.setItemValue(bankersDTO.getItemValue());
        this.setSequence(bankersDTO.getSequence());
    }
}