package com.rony.creditinfix.services.financialInfo.currencyDailyRate;


import com.rony.creditinfix.entity.financialInfo.CurrencyDailyRate;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.CurrencyDailyRateDTO;
import com.rony.creditinfix.repository.financialInfo.CurrencyDailyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrencyDailyRateImpl implements CurrencyDailyRateService {

    @Autowired
    CurrencyDailyRateRepository currencyDailyRateRepository;


    @Override
    public List<CurrencyDailyRateDTO> saveAll(List<CurrencyDailyRateDTO> currencyDailyRateDTOS, Date currencyDate) {
        List<CurrencyDailyRate> currencyDailyRateList = new ArrayList<>();
        for (CurrencyDailyRateDTO currencyDailyRateDTO : currencyDailyRateDTOS) {
            CurrencyDailyRate currencyDailyRate = new CurrencyDailyRate(currencyDailyRateDTO);
            currencyDailyRateList.add(currencyDailyRate);
        }
        currencyDailyRateRepository.saveAll(currencyDailyRateList);

        return this.findAllByCurrencyDate(currencyDate);
    }

    @Override
    public List<CurrencyDailyRateDTO> findAllByCurrencyDate(Date currencyDate) {
        List<CurrencyDailyRateDTO> currencyDailyRateDTOS = new ArrayList<>();
        List<CurrencyDailyRate> currencyDailyRateList = currencyDailyRateRepository.findAllByCurrencyDate(currencyDate);
        for (CurrencyDailyRate currencyDailyRate : currencyDailyRateList) {
            CurrencyDailyRateDTO currencyDailyRateDTO = new CurrencyDailyRateDTO(currencyDailyRate);
            currencyDailyRateDTOS.add(currencyDailyRateDTO);
        }

        return currencyDailyRateDTOS;
    }

    @Override
    public CurrencyDailyRateDTO create(CurrencyDailyRateDTO currencyDailyRateDTO) throws ServiceException {
        return null;
    }

    @Override
    public CurrencyDailyRateDTO update(Long id, CurrencyDailyRateDTO currencyDailyRateDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public CurrencyDailyRateDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<CurrencyDailyRateDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CurrencyDailyRateDTO> findAll() {
        List<CurrencyDailyRateDTO> currencyDailyRateDTOS = new ArrayList<>();
        List<CurrencyDailyRate> currencyDailyRateList = currencyDailyRateRepository.findAll();
        for (CurrencyDailyRate currencyDailyRate : currencyDailyRateList) {
            CurrencyDailyRateDTO currencyDailyRateDTO = new CurrencyDailyRateDTO(currencyDailyRate);
            currencyDailyRateDTOS.add(currencyDailyRateDTO);
        }
        return currencyDailyRateDTOS;
    }
}
