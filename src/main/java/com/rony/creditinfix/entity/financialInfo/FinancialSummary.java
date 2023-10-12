package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_summary")
public class FinancialSummary extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private double amount;

    @Column(name = "comments")
    private String comments;

    public FinancialSummary(FinancialSummaryDTO financialSummaryDTO){
        this.setId(financialSummaryDTO.getId());
        this.setVersion(financialSummaryDTO.getVersion());
        this.setCompanyInfo(financialSummaryDTO.getCompanyInfo());
        this.setItemCode(financialSummaryDTO.getItemCode());
        this.setCurrency(financialSummaryDTO.getCurrency());
        this.setAmount(financialSummaryDTO.getAmount());
        this.setComments(financialSummaryDTO.getComments());
    }

}
