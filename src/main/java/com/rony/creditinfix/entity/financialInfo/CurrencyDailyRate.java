package com.rony.creditinfix.entity.financialInfo;

import com.rony.creditinfix.entity.CommonColumn;
import com.rony.creditinfix.models.financialInfo.CurrencyDailyRateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency_daily_rate")
public class CurrencyDailyRate extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long countryId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "currency_rate")
    private double currencyRate;

    @Column(name = "currency_date")
    private Date currencyDate;

    @Column(name = "unit")
    private int unit;

    public CurrencyDailyRate(CurrencyDailyRateDTO currencyDailyRateDTO){
        this.setId(currencyDailyRateDTO.getId());
        this.setVersion(currencyDailyRateDTO.getVersion());
        this.setCountryId(currencyDailyRateDTO.getCountryId());
        this.setCurrency(currencyDailyRateDTO.getCurrency());
        this.setCurrencyRate(currencyDailyRateDTO.getCurrencyRate());
        this.setCurrencyDate(currencyDailyRateDTO.getCurrencyDate());
        this.setUnit(currencyDailyRateDTO.getUnit());

    }
}
