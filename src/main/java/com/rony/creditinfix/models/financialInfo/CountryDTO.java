package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Country;
import com.rony.creditinfix.models.CommonColumnDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO  extends CommonColumnDTO {
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
