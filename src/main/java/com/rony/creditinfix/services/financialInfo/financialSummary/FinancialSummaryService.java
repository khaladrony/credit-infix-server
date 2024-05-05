package com.rony.creditinfix.services.financialInfo.financialSummary;

import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface FinancialSummaryService extends AbstractService<FinancialSummaryDTO> {

    List<FinancialSummaryDTO> saveAll(List<FinancialSummaryDTO> financialSummaryDTOS, Long companyInfoId);

    List<FinancialSummaryDTO> findAllByCompanyInfoId(Long companyInfoId);
}
