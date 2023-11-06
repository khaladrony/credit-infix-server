package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialSummaryRepository extends JpaRepository<FinancialSummary, Long> {

    List<FinancialSummary> findAllByCompanyInfoId(Long id);
}
