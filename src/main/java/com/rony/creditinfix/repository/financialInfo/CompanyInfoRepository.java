package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
}
