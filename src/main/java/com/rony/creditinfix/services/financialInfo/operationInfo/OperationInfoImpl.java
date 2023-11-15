package com.rony.creditinfix.services.financialInfo.operationInfo;

import com.rony.creditinfix.entity.financialInfo.OperationInfo;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.OperationInfoDTO;
import com.rony.creditinfix.models.financialInfo.ReportDataDTO;
import com.rony.creditinfix.repository.financialInfo.OperationInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


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
            if (operationInfoDTO.getItemCode().equalsIgnoreCase("Activities:")
                    && operationInfoDTO.getItemValue().equalsIgnoreCase("")) {
                operationInfoDTO.setItemValue(operationInfoDTO.getCompanyInfo().getBusinessType());
            }
            operationInfoDTOS.add(operationInfoDTO);
        }
        return operationInfoDTOS;
    }

    @Override
    public List<List<ReportDataDTO>> findAllByCompanyInfoIdForReport(Long companyInfoId) {
        List<OperationInfoDTO> operationInfoDTOS = this.findAllByCompanyInfoId(companyInfoId);

        Map<Integer, List<OperationInfoDTO>> operationInfoByItem = new HashMap<>();
        List<ReportDataDTO> rows = null;
        List<List<ReportDataDTO>> data = new ArrayList<>();

        operationInfoByItem = operationInfoDTOS.stream()
                .collect(Collectors.groupingBy(OperationInfoDTO::getSequence));

        for (List<OperationInfoDTO> list : operationInfoByItem.values()) {
            boolean isFirstData = true;
            for (OperationInfoDTO infoDTO : list) {
                if (isFirstData && list.size() > 1
                        && !infoDTO.getItemCode().equals("")
                        && !infoDTO.getItemValue().equals("")) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(list.size(), 0, infoDTO.getItemCode()));
                    rows.add(new ReportDataDTO(1, 0, infoDTO.getItemValue()));
                    data.add(rows);
                    isFirstData = false;
                } else if (!isFirstData && list.size() > 1) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, infoDTO.getItemValue()));
                    data.add(rows);
                } else {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, infoDTO.getItemCode()));
                    rows.add(new ReportDataDTO(1, 0, infoDTO.getItemValue()));
                    data.add(rows);
                }

            }
        }


        return data;
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
        OperationInfoDTO operationInfoDTO = this.findById(id);
        if (operationInfoDTO == null) throw new NotFoundException();

        operationInfoRepository.deleteById(id);
        return true;
    }

    @Override
    public OperationInfoDTO findById(Long id) throws ServiceException {
        Optional<OperationInfo> operationInfo = operationInfoRepository.findById(id);
        return operationInfo.isEmpty() ? null : new OperationInfoDTO(operationInfo.get());

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
