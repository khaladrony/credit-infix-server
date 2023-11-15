package com.rony.creditinfix.services.financialInfo.financialSummary;

import com.rony.creditinfix.entity.financialInfo.CompanyInfo;
import com.rony.creditinfix.entity.financialInfo.FinancialSummary;
import com.rony.creditinfix.exception.NotFoundException;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import com.rony.creditinfix.repository.financialInfo.FinancialSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FinancialSummaryImpl implements FinancialSummaryService {

    @Autowired
    private FinancialSummaryRepository financialSummaryRepository;



    @Override
    public FinancialSummaryDTO create(FinancialSummaryDTO financialSummaryDTO) throws ServiceException {
        return null;
    }

    @Override
    public FinancialSummaryDTO update(Long id, FinancialSummaryDTO financialSummaryDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        FinancialSummaryDTO financialSummaryDTO = this.findById(id);
        if (financialSummaryDTO == null) throw new NotFoundException();

        financialSummaryRepository.deleteById(id);
        return true;
    }

    @Override
    public FinancialSummaryDTO findById(Long id) throws ServiceException {
        Optional<FinancialSummary> financialSummary = financialSummaryRepository.findById(id);
        return financialSummary.isEmpty() ? null : new FinancialSummaryDTO(financialSummary.get());
    }

    @Override
    public Page<FinancialSummaryDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<FinancialSummaryDTO> findAll() {
        List<FinancialSummaryDTO> financialSummaryDTOS = new ArrayList<>();
        List<FinancialSummary> financialSummaryList = financialSummaryRepository.findAll();
        for (FinancialSummary financialSummary : financialSummaryList) {
            FinancialSummaryDTO financialSummaryDTO = new FinancialSummaryDTO(financialSummary);
            financialSummaryDTOS.add(financialSummaryDTO);
        }
        return financialSummaryDTOS;
    }

    @Override
    public List<FinancialSummaryDTO> saveAll(List<FinancialSummaryDTO> financialSummaryDTOS, Long companyInfoId) {
        List<FinancialSummary> financialSummaryList = new ArrayList<>();
        for (FinancialSummaryDTO financialSummaryDTO : financialSummaryDTOS) {
            FinancialSummary financialSummary = new FinancialSummary(financialSummaryDTO);
            financialSummaryList.add(financialSummary);
        }
        financialSummaryRepository.saveAll(financialSummaryList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<FinancialSummaryDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<FinancialSummaryDTO> financialSummaryDTOS = new ArrayList<>();
        List<FinancialSummary> financialSummaryList = financialSummaryRepository.findAllByCompanyInfoId(companyInfoId);
        for (FinancialSummary financialSummary : financialSummaryList) {
            FinancialSummaryDTO financialSummaryDTO = new FinancialSummaryDTO(financialSummary);
            financialSummaryDTOS.add(financialSummaryDTO);
        }
        return financialSummaryDTOS;
    }
}
