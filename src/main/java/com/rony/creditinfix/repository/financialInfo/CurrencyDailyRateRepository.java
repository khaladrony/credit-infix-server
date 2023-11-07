package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CurrencyDailyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public interface CurrencyDailyRateRepository extends JpaRepository<CurrencyDailyRate, Long> {

//    List<CurrencyDailyRate> findAllByCurrencyDate(Date currencyDate);
    List<CurrencyDailyRate> findAllByCurrencyDate(@Temporal(TemporalType.DATE) @Param("currencyDate") Date currencyDate);
}
