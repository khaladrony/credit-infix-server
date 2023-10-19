package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.SummaryOpinionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "summary_opinion")
public class SummaryOpinion extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_value", length = 1500)
    private String itemValue;

    public SummaryOpinion(SummaryOpinionDTO summaryOpinionDTO) {
        this.setId(summaryOpinionDTO.getId());
        this.setVersion(summaryOpinionDTO.getVersion());
        this.setCompanyInfo(summaryOpinionDTO.getCompanyInfo());
        this.setItemCode(summaryOpinionDTO.getItemCode());
        this.setItemValue(summaryOpinionDTO.getItemValue());
    }
}
