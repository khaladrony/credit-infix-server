package com.rony.creditinfix.services.financialInfo.management;

import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface ManagementService extends AbstractService<ManagementDTO> {

    List<ManagementDTO> saveAll(List<ManagementDTO> managementDTOS, Long companyInfoId);

    List<ManagementDTO> findAllByCompanyInfoId(Long companyInfoId);
}
