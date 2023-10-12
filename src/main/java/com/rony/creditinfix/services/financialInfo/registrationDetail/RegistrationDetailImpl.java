package com.rony.creditinfix.services.financialInfo.registrationDetail;


import com.rony.creditinfix.entity.financialInfo.RegistrationDetail;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import com.rony.creditinfix.repository.financialInfo.RegistrationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationDetailImpl implements RegistrationDetailService{

    @Autowired
    RegistrationDetailRepository registrationDetailRepository;

    @Override
    public List<RegistrationDetailDTO> saveAll(List<RegistrationDetailDTO> registrationDetailDTOS, Long companyInfoId) {
        List<RegistrationDetail> registrationDetails = new ArrayList<>();
        for (RegistrationDetailDTO registrationDetailDTO : registrationDetailDTOS) {
            RegistrationDetail registrationDetail = new RegistrationDetail(registrationDetailDTO);
            registrationDetails.add(registrationDetail);
        }
        registrationDetailRepository.saveAll(registrationDetails);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<RegistrationDetailDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<RegistrationDetailDTO> registrationDetailDTOS = new ArrayList<>();
        List<RegistrationDetail> registrationDetails = registrationDetailRepository.findAllByCompanyInfoId(companyInfoId);
        for (RegistrationDetail registrationDetail : registrationDetails) {
            RegistrationDetailDTO registrationDetailDTO = new RegistrationDetailDTO(registrationDetail);
            registrationDetailDTOS.add(registrationDetailDTO);
        }
        return registrationDetailDTOS;
    }

    @Override
    public RegistrationDetailDTO create(RegistrationDetailDTO registrationDetailDTO) throws ServiceException {
        return null;
    }

    @Override
    public RegistrationDetailDTO update(Long id, RegistrationDetailDTO registrationDetailDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public RegistrationDetailDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<RegistrationDetailDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<RegistrationDetailDTO> findAll() {
        return null;
    }
}
