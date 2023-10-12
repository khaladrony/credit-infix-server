package com.rony.creditinfix.services.financialInfo.financialInformation;


import com.rony.creditinfix.entity.financialInfo.FinancialInformation;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.repository.financialInfo.FinancialInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FinancialInformationImpl implements FinancialInformationService {

    @Autowired
    private FinancialInformationRepository financialInformationRepository;


    @Override
    public List<FinancialInformationDTO> saveAll(List<FinancialInformationDTO> financialInformationDTOS, Long companyInfoId) {
        List<FinancialInformation> financialInformationList = new ArrayList<>();
        for (FinancialInformationDTO financialInformationDTO : financialInformationDTOS) {
            FinancialInformation corporateStructure = new FinancialInformation(financialInformationDTO);
            financialInformationList.add(corporateStructure);
        }
        financialInformationRepository.saveAll(financialInformationList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<FinancialInformationDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<FinancialInformationDTO> financialInformationDTOS = new ArrayList<>();
        List<FinancialInformation> financialInformationList = financialInformationRepository.findAllByCompanyInfoId(companyInfoId);
        for (FinancialInformation financialInformation : financialInformationList) {
            FinancialInformationDTO financialInformationDTO = new FinancialInformationDTO(financialInformation);
            financialInformationDTOS.add(financialInformationDTO);
        }
        return financialInformationDTOS;
    }

    @Override
    public FinancialInformationDTO create(FinancialInformationDTO financialInformationDTO) throws ServiceException {
        return null;
    }

    @Override
    public FinancialInformationDTO update(Long id, FinancialInformationDTO financialInformationDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public FinancialInformationDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<FinancialInformationDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<FinancialInformationDTO> findAll() {
        return null;
    }
}
