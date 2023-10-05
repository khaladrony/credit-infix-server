package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
}
