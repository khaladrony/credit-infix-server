package com.rony.creditinfix.services.financialInfo.currencyDailyRate;

import com.rony.creditinfix.models.financialInfo.CurrencyDailyRateDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.Date;
import java.util.List;

public interface CurrencyDailyRateService  extends AbstractService<CurrencyDailyRateDTO> {

    List<CurrencyDailyRateDTO> saveAll(List<CurrencyDailyRateDTO> currencyDailyRateDTOS, Date currencyDate);

    List<CurrencyDailyRateDTO> findAllByCurrencyDate(Date currencyDate);
}
