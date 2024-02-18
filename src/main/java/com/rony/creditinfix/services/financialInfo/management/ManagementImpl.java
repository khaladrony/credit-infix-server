package com.rony.creditinfix.services.financialInfo.management;

import com.rony.creditinfix.entity.financialInfo.Management;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.repository.financialInfo.ManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ManagementImpl implements ManagementService {

    @Autowired
    ManagementRepository managementRepository;


    @Override
    public List<ManagementDTO> saveAll(List<ManagementDTO> managementDTOS, Long companyInfoId) {
        List<Management> managementList = new ArrayList<>();

        //Delete existing entries
        managementRepository.deleteAllByCompanyInfoId(companyInfoId);

        for (ManagementDTO managementDTO : managementDTOS) {
            Management management = new Management(managementDTO);
            managementList.add(management);
        }
        managementRepository.saveAll(managementList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<ManagementDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<ManagementDTO> managementDTOS = new ArrayList<>();
        List<Management> managementList = managementRepository.findAllByCompanyInfoId(companyInfoId);
        for (Management management : managementList) {
            ManagementDTO managementDTO = new ManagementDTO(management);
            managementDTOS.add(managementDTO);
        }
        return managementDTOS;
    }

    @Override
    public ManagementDTO create(ManagementDTO managementDTO) throws ServiceException {
        return null;
    }

    @Override
    public ManagementDTO update(Long id, ManagementDTO managementDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public ManagementDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<ManagementDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<ManagementDTO> findAll() {
        return null;
    }
}
