package com.rony.creditinfix.services.financialInfo.natureOfBusiness;

import com.rony.creditinfix.models.financialInfo.NatureOfBusinessDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface NatureOfBusinessService extends AbstractService<NatureOfBusinessDTO> {

    List<NatureOfBusinessDTO> saveAll(List<NatureOfBusinessDTO> natureOfBusinessDTOS, Long companyInfoId);

    List<NatureOfBusinessDTO> findAllByCompanyInfoId(Long companyInfoId);
}