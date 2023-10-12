package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.FinancialNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialNoteDTO {
    private Long id;
    private int version;

    private CompanyInfo companyInfo;
    private String itemCode;
    private String itemValue;

    public FinancialNoteDTO(FinancialNote financialNote){
        this.setId(financialNote.getId());
        this.setVersion(financialNote.getVersion());
        this.setCompanyInfo(financialNote.getCompanyInfo());
        this.setItemCode(financialNote.getItemCode());
        this.setItemValue(financialNote.getItemValue());
    }
}
