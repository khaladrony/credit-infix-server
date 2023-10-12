package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Rating;
import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RiskLevelRepository extends JpaRepository<RiskLevel, Long> {

    @Query(value = "select * from risk_level rl where rl.start_range <= ?1 AND rl.end_range >= ?1 ",  nativeQuery = true)
    RiskLevel findRiskLevelBetweenRange(int creditRating);
}
