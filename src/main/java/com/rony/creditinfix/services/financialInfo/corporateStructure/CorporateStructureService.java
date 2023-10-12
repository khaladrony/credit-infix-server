package com.rony.creditinfix.services.financialInfo.corporateStructure;

import com.rony.creditinfix.models.financialInfo.CorporateStructureDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface CorporateStructureService extends AbstractService<CorporateStructureDTO> {

    List<CorporateStructureDTO> saveAll(List<CorporateStructureDTO> corporateStructureDTOS, Long companyInfoId);

    List<CorporateStructureDTO> findAllByCompanyInfoId(Long companyInfoId);
}