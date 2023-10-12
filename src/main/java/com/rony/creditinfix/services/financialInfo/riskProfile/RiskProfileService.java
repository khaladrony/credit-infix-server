package com.rony.creditinfix.services.financialInfo.riskProfile;

import com.rony.creditinfix.models.financialInfo.RiskProfileDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface RiskProfileService  extends AbstractService<RiskProfileDTO> {


    List<RiskProfileDTO> saveAll(List<RiskProfileDTO> managementDTOS, Long companyInfoId);

    List<RiskProfileDTO> findAllByCompanyInfoId(Long companyInfoId);
}
