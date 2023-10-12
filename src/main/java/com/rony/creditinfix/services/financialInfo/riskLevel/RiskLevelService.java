package com.rony.creditinfix.services.financialInfo.riskLevel;

import com.rony.creditinfix.entity.financialInfo.RiskLevel;
import com.rony.creditinfix.models.financialInfo.RiskLevelDTO;
import com.rony.creditinfix.services.AbstractService;

public interface RiskLevelService extends AbstractService<RiskLevelDTO> {

    RiskLevel findRiskLevelBetweenRange(int creditRating);
}
