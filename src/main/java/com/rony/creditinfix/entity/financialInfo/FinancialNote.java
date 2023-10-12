package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.FinancialNoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_note")
public class FinancialNote extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_value", length = 500)
    private String itemValue;

    public FinancialNote(FinancialNoteDTO financialNoteDTO){
        this.setId(financialNoteDTO.getId());
        this.setVersion(financialNoteDTO.getVersion());
        this.setCompanyInfo(financialNoteDTO.getCompanyInfo());
        this.setItemCode(financialNoteDTO.getItemCode());
        this.setItemValue(financialNoteDTO.getItemValue());
    }
}
