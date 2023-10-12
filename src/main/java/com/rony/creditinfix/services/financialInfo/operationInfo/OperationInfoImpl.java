package com.rony.creditinfix.services.financialInfo.operationInfo;

import com.rony.creditinfix.entity.financialInfo.OperationInfo;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import com.rony.creditinfix.repository.financialInfo.OperationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OperationInfoImpl implements OperationInfoService {

    @Autowired
    OperationInfoRepository operationInfoRepository;


    @Override
    public List<OperationInfoDTO> saveAll(List<OperationInfoDTO> operationInfoDTOS, Long companyInfoId) {
        List<OperationInfo> operationInfoList = new ArrayList<>();
        for (OperationInfoDTO operationInfoDTO : operationInfoDTOS) {
            OperationInfo operationInfo = new OperationInfo(operationInfoDTO);
            operationInfoList.add(operationInfo);
        }
        operationInfoRepository.saveAll(operationInfoList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<OperationInfoDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<OperationInfoDTO> operationInfoDTOS = new ArrayList<>();
        List<OperationInfo> operationInfoList = operationInfoRepository.findAllByCompanyInfoId(companyInfoId);
        for (OperationInfo operationInfo : operationInfoList) {
            OperationInfoDTO operationInfoDTO = new OperationInfoDTO(operationInfo);
            operationInfoDTOS.add(operationInfoDTO);
        }
        return operationInfoDTOS;
    }

    @Override
    public OperationInfoDTO create(OperationInfoDTO operationInfoDTO) throws ServiceException {
        return null;
    }

    @Override
    public OperationInfoDTO update(Long id, OperationInfoDTO operationInfoDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public OperationInfoDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<OperationInfoDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<OperationInfoDTO> findAll() {
        return null;
    }
}
