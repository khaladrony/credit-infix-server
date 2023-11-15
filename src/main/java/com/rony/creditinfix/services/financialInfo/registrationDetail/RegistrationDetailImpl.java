package com.rony.creditinfix.services.financialInfo.registrationDetail;


import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import com.rony.creditinfix.entity.financialInfo.RegistrationDetail;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.RegistrationDetailDTO;
import com.rony.creditinfix.models.financialInfo.ReportDataDTO;
import com.rony.creditinfix.repository.financialInfo.FinancialSummaryRepository;
import com.rony.creditinfix.repository.financialInfo.RegistrationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RegistrationDetailImpl implements RegistrationDetailService {

    @Autowired
    RegistrationDetailRepository registrationDetailRepository;
    @Autowired
    FinancialSummaryRepository financialSummaryRepository;

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
    public List<List<ReportDataDTO>> findAllByCompanyInfoIdForReport(Long companyInfoId) {
        List<RegistrationDetailDTO> registrationDetailDTOS = this.findAllByCompanyInfoId(companyInfoId);

        this.setFinancialData(registrationDetailDTOS, companyInfoId);

        Map<Integer, List<RegistrationDetailDTO>> regDetailByItem = new HashMap<>();
        List<ReportDataDTO> rows = null;
        List<List<ReportDataDTO>> data = new ArrayList<>();

        regDetailByItem = registrationDetailDTOS.stream()
                .collect(Collectors.groupingBy(RegistrationDetailDTO::getSequence));

        for (List<RegistrationDetailDTO> list : regDetailByItem.values()) {
            boolean isFirstData = true;
            for (RegistrationDetailDTO detailDTO : list) {
                if (isFirstData && list.size() > 1
                        && !detailDTO.getItem().equals("")
                        && !detailDTO.getSubItem().equals("")
                        && !detailDTO.getItemValue().equals("")) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(list.size(), 0, detailDTO.getItem()));
                    rows.add(new ReportDataDTO(1, 0, detailDTO.getSubItem()));
                    rows.add(new ReportDataDTO(1, 0, detailDTO.getItemValue()));
                    data.add(rows);
                    isFirstData = false;
                } else if (detailDTO.getSubItem().equals("") && list.size() == 1) {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, detailDTO.getItem()));
                    rows.add(new ReportDataDTO(0, 2, detailDTO.getItemValue()));
                    data.add(rows);

                } else {
                    rows = new ArrayList<>();
                    rows.add(new ReportDataDTO(1, 0, detailDTO.getSubItem()));
                    rows.add(new ReportDataDTO(1, 0, detailDTO.getItemValue()));
                    data.add(rows);
                }

            }
        }


        return data;
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
        RegistrationDetailDTO registrationDetailDTO = this.findById(id);
        if (registrationDetailDTO == null) throw new NotFoundException();

        registrationDetailRepository.deleteById(id);
        return true;
    }

    @Override
    public RegistrationDetailDTO findById(Long id) throws ServiceException {
        Optional<RegistrationDetail> registrationDetail = registrationDetailRepository.findById(id);
        return registrationDetail.isEmpty() ? null : new RegistrationDetailDTO(registrationDetail.get());
    }

    @Override
    public Page<RegistrationDetailDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<RegistrationDetailDTO> findAll() {
        return null;
    }

    private void setFinancialData(List<RegistrationDetailDTO> registrationDetailDTOS, Long companyInfoId) {

        List<FinancialSummary> financialSummaryList = financialSummaryRepository.findAllByCompanyInfoId(companyInfoId);

        List<RegistrationDetailDTO> registrationDetailDTOList = registrationDetailDTOS.stream()
                .filter(obj -> obj.getItem().equalsIgnoreCase("Capital:"))
                .collect(Collectors.toList());

        int i = 0, j = 0;
        for (RegistrationDetailDTO detailDTO : registrationDetailDTOList) {
            for (FinancialSummary finSummary : financialSummaryList) {
                if (i == j) {
                    detailDTO.setSubItem(finSummary.getItemCode());
                    detailDTO.setItemValue(detailDTO.getCompanyInfo().getCurrency() + " " + String.format("%.0f", finSummary.getAmount()));
                    break;
                }
                j++;
            }
            i++;
            j = 0;
        }
    }
}
