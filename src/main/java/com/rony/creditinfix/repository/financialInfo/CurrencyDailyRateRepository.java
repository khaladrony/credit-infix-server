package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CurrencyDailyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface CurrencyDailyRateRepository extends JpaRepository<CurrencyDailyRate, Long> {

    List<CurrencyDailyRate> findAllByCurrencyDate(Date currencyDate);
}
