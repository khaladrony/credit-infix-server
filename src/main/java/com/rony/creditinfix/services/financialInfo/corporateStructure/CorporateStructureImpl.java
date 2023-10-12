package com.rony.creditinfix.services.financialInfo.corporateStructure;

import com.rony.creditinfix.entity.financialInfo.CorporateStructure;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.CorporateStructureDTO;
import com.rony.creditinfix.repository.financialInfo.CorporateStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CorporateStructureImpl implements CorporateStructureService {

    @Autowired
    CorporateStructureRepository corporateStructureRepository;


    @Override
    public List<CorporateStructureDTO> saveAll(List<CorporateStructureDTO> corporateStructureDTOS, Long companyInfoId) {
        List<CorporateStructure> corporateStructureList = new ArrayList<>();
        for (CorporateStructureDTO corporateStructureDTO : corporateStructureDTOS) {
            CorporateStructure corporateStructure = new CorporateStructure(corporateStructureDTO);
            corporateStructureList.add(corporateStructure);
        }
        corporateStructureRepository.saveAll(corporateStructureList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<CorporateStructureDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<CorporateStructureDTO> corporateStructureDTOS = new ArrayList<>();
        List<CorporateStructure> corporateStructureList = corporateStructureRepository.findAllByCompanyInfoId(companyInfoId);
        for (CorporateStructure corporateStructure : corporateStructureList) {
            CorporateStructureDTO corporateStructureDTO = new CorporateStructureDTO(corporateStructure);
            corporateStructureDTOS.add(corporateStructureDTO);
        }
        return corporateStructureDTOS;
    }

    @Override
    public CorporateStructureDTO create(CorporateStructureDTO corporateStructureDTO) throws ServiceException {
        return null;
    }

    @Override
    public CorporateStructureDTO update(Long id, CorporateStructureDTO corporateStructureDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public CorporateStructureDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<CorporateStructureDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CorporateStructureDTO> findAll() {
        return null;
    }
}
