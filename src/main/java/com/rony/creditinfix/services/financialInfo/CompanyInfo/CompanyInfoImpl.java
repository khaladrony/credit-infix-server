package com.rony.creditinfix.services.financialInfo.CompanyInfo;


import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.CompanyInfoDTO;
import com.rony.creditinfix.repository.financialInfo.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyInfoImpl implements CompanyInfoService {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    @Override
    public CompanyInfoDTO create(CompanyInfoDTO companyInfoDTO) throws ServiceException {
        CompanyInfo companyInfo = new CompanyInfo(companyInfoDTO);

        this.duplicateCheck(companyInfoDTO, "save");
        return new CompanyInfoDTO(companyInfoRepository.save(companyInfo));
    }

    @Override
    public CompanyInfoDTO update(Long id, CompanyInfoDTO companyInfoDTO) throws ServiceException {
        CompanyInfoDTO _companyInfoDTO = this.findById(id);
        if (_companyInfoDTO == null) throw new NotFoundException();

        this.duplicateCheck(_companyInfoDTO, "");

        CompanyInfo companyInfo = new CompanyInfo(companyInfoDTO);

        return new CompanyInfoDTO(companyInfoRepository.save(companyInfo));
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        CompanyInfoDTO companyInfoDTO = this.findById(id);
        if (companyInfoDTO == null) throw new NotFoundException();

        companyInfoRepository.deleteById(id);
        return true;
    }

    @Override
    public CompanyInfoDTO findById(Long id) throws ServiceException {
        Optional<CompanyInfo> companyInfo = companyInfoRepository.findById(id);
        return companyInfo.isPresent() ? new CompanyInfoDTO(companyInfo.orElse(null)) : null;
    }

    @Override
    public Page<CompanyInfoDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CompanyInfoDTO> findAll() {
        List<CompanyInfoDTO> companyInfoDTOS = new ArrayList<>();
        List<CompanyInfo> companyInfos = companyInfoRepository.findAll();
        for (CompanyInfo companyInfo : companyInfos) {
            CompanyInfoDTO companyInfoDTO = new CompanyInfoDTO(companyInfo);
            companyInfoDTOS.add(companyInfoDTO);
        }
        return companyInfoDTOS;
    }


    private void duplicateCheck(CompanyInfoDTO companyInfoDTO, String type) throws ServiceException {
//        UserDTO userDTOObj = this.findByUsername(userDTO.getTokenType());
//        if (userDTOObj == null) return;
//
//        if (type.equalsIgnoreCase("save")) {
//            throw new GeneralException("The user exists");
//        } else {
//            int count = userRepository.countByUsername(userDTO.getId(), userDTO.getTokenType());
//            if (count >= 1) {
//                throw new GeneralException("The user exists");
//            }
//        }

    }
}
