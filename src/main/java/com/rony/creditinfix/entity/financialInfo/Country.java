package com.rony.creditinfix.entity.financialInfo;


import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.CountryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "currency")
    private String currency;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "risk_assessment", length = 4000)
    private String riskAssessment;

    public Country(CountryDTO countryDTO){
        this.setId(countryDTO.getId());
        this.setVersion(countryDTO.getVersion());
        this.setName(countryDTO.getName());
        this.setCurrency(countryDTO.getCurrency());
        this.setCurrencyName(countryDTO.getCurrencyName());
        this.setRiskAssessment(countryDTO.getRiskAssessment());

    }
}
