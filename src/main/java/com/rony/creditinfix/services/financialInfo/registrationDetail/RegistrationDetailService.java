package com.rony.creditinfix.services.financialInfo.registrationDetail;

import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface RegistrationDetailService extends AbstractService<RegistrationDetailDTO> {

    public List<RegistrationDetailDTO> saveAll(List<RegistrationDetailDTO> registrationDetailDTOS, Long companyInfoId);

    public List<RegistrationDetailDTO> findAllByCompanyInfoId(Long companyInfoId);
}
