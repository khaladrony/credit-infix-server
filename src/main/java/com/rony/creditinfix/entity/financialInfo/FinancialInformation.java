package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "financial_information")
public class FinancialInformation extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_info_id", nullable = false)
    private CompanyInfo companyInfo;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "third_year")
    private String thirdYear;

    @Column(name = "second_year")
    private String secondYear;

    @Column(name = "first_year")
    private String firstYear;

    @Column(name = "html_type")
    private String htmlType;    //add a constant string 'header'

    public FinancialInformation(FinancialInformationDTO financialInformationDTO) {
        this.setId(financialInformationDTO.getId());
        this.setVersion(financialInformationDTO.getVersion());
        this.setCompanyInfo(financialInformationDTO.getCompanyInfo());
        this.setItemCode(financialInformationDTO.getItemCode());
        this.setThirdYear(financialInformationDTO.getThirdYear());
        this.setSecondYear(financialInformationDTO.getSecondYear());
        this.setFirstYear(financialInformationDTO.getFirstYear());
        this.setHtmlType(financialInformationDTO.getHtmlType());
    }
}
