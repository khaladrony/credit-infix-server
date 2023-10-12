package com.rony.creditinfix.services.financialInfo.operationInfo;

import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface OperationInfoService extends AbstractService<OperationInfoDTO> {

    List<OperationInfoDTO> saveAll(List<OperationInfoDTO> operationInfoDTOS, Long companyInfoId);

    List<OperationInfoDTO> findAllByCompanyInfoId(Long companyInfoId);
}
