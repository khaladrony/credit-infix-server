package com.rony.creditinfix.models.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CurrencyDailyRate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDailyRateDTO {
    private Long id;
    private int version;
    private Long countryId;
    private String currency;
    private double currencyRate;
    private Date currencyDate;
    private int unit;

    public CurrencyDailyRateDTO(CurrencyDailyRate currencyDailyRate){
        this.setId(currencyDailyRate.getId());
        this.setVersion(currencyDailyRate.getVersion());
        this.setCountryId(currencyDailyRate.getCountryId());
        this.setCurrency(currencyDailyRate.getCurrency());
        this.setCurrencyRate(currencyDailyRate.getCurrencyRate());
        this.setCurrencyDate(currencyDailyRate.getCurrencyDate());
        this.setUnit(currencyDailyRate.getUnit());

    }
}
