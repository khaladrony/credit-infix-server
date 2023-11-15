package com.rony.creditinfix.services.financialInfo.bankers;

import com.rony.creditinfix.models.financialInfo.BankersDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface BankersService extends AbstractService<BankersDTO> {

    List<BankersDTO> saveAll(List<BankersDTO> bankersDTOS, Long companyInfoId);

    List<BankersDTO> findAllByCompanyInfoId(Long companyInfoId);
}
