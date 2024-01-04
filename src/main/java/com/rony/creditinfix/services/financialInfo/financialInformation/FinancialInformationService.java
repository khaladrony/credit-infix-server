package com.rony.creditinfix.services.financialInfo.financialInformation;

import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface FinancialInformationService extends AbstractService<FinancialInformationDTO> {

    List<FinancialInformationDTO> saveAll(List<FinancialInformationDTO> financialInformationDTOS, Long companyInfoId);

    List<FinancialInformationDTO> findAllByCompanyInfoId(Long companyInfoId);

    void deleteAllByCompanyInfoId(Long companyInfoId);
}