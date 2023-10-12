package com.rony.creditinfix.services.financialInfo.financialSummary;

import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface FinancialSummaryService extends AbstractService<FinancialSummaryDTO> {

    public List<FinancialSummaryDTO> saveAll(List<FinancialSummaryDTO> financialSummaryDTOS, Long companyInfoId);

    public List<FinancialSummaryDTO> findAllByCompanyInfoId(Long companyInfoId);
}
