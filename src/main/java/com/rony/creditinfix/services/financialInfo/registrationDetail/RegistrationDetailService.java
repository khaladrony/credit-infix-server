package com.rony.creditinfix.services.financialInfo.registrationDetail;

import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import com.rony.creditinfix.models.financialInfo.ReportDataDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;
import java.util.Map;

public interface RegistrationDetailService extends AbstractService<RegistrationDetailDTO> {

    List<RegistrationDetailDTO> saveAll(List<RegistrationDetailDTO> registrationDetailDTOS, Long companyInfoId);

    List<RegistrationDetailDTO> findAllByCompanyInfoId(Long companyInfoId);

    List<List<ReportDataDTO>> findAllByCompanyInfoIdForReport(Long companyInfoId);
}
