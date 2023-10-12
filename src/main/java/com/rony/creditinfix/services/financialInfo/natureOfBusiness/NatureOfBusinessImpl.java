package com.rony.creditinfix.services.financialInfo.natureOfBusiness;

import com.rony.creditinfix.entity.financialInfo.NatureOfBusiness;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.NatureOfBusinessDTO;
import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import com.rony.creditinfix.repository.financialInfo.NatureOfBusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NatureOfBusinessImpl implements NatureOfBusinessService {

    @Autowired
    NatureOfBusinessRepository natureOfBusinessRepository;

    @Override
    public List<NatureOfBusinessDTO> saveAll(List<NatureOfBusinessDTO> natureOfBusinessDTOS, Long companyInfoId) {
        List<NatureOfBusiness> natureOfBusinessList = new ArrayList<>();
        for (NatureOfBusinessDTO natureOfBusinessDTO : natureOfBusinessDTOS) {
            NatureOfBusiness natureOfBusiness = new NatureOfBusiness(natureOfBusinessDTO);
            natureOfBusinessList.add(natureOfBusiness);
        }
        natureOfBusinessRepository.saveAll(natureOfBusinessList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<NatureOfBusinessDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<NatureOfBusinessDTO> natureOfBusinessDTOS = new ArrayList<>();
        List<NatureOfBusiness> natureOfBusinessList = natureOfBusinessRepository.findAllByCompanyInfoId(companyInfoId);
        for (NatureOfBusiness natureOfBusiness : natureOfBusinessList) {
            NatureOfBusinessDTO natureOfBusinessDTO = new NatureOfBusinessDTO(natureOfBusiness);
            natureOfBusinessDTOS.add(natureOfBusinessDTO);
        }
        return natureOfBusinessDTOS;
    }

    @Override
    public NatureOfBusinessDTO create(NatureOfBusinessDTO natureOfBusinessDTO) throws ServiceException {
        return null;
    }

    @Override
    public NatureOfBusinessDTO update(Long id, NatureOfBusinessDTO natureOfBusinessDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public NatureOfBusinessDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<NatureOfBusinessDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<NatureOfBusinessDTO> findAll() {
        return null;
    }
}
