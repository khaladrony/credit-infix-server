package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private Long id;
    private int version;
    private String name;
    private String currency;
    private String currencyName;
    private String riskAssessment;

    public CountryDTO(Country country){
        this.setId(country.getId());
        this.setVersion(country.getVersion());
        this.setName(country.getName());
        this.setCurrency(country.getCurrency());
        this.setCurrencyName(country.getCurrencyName());
        this.setRiskAssessment(country.getRiskAssessment());
    }
}
