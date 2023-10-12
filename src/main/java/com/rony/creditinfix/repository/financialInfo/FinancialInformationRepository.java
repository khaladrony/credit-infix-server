package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.FinancialInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialInformationRepository extends JpaRepository<FinancialInformation, Long> {

    List<FinancialInformation> findAllByCompanyInfoId(Long id);
}
