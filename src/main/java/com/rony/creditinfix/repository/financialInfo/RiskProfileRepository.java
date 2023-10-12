package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.RiskProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RiskProfileRepository extends JpaRepository<RiskProfile, Long> {

    List<RiskProfile> findAllByCompanyInfoId(Long id);
}
