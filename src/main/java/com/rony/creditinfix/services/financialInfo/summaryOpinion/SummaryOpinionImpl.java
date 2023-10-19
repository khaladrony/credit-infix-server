package com.rony.creditinfix.services.financialInfo.summaryOpinion;

import com.rony.creditinfix.entity.financialInfo.SummaryOpinion;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.OrderDetailDTO;
import com.rony.creditinfix.models.financialInfo.SummaryOpinionDTO;
import com.rony.creditinfix.repository.financialInfo.SummaryOpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SummaryOpinionImpl implements SummaryOpinionService {

    @Autowired
    private SummaryOpinionRepository summaryOpinionRepository;

    @Override
    public List<SummaryOpinionDTO> saveAll(List<SummaryOpinionDTO> summaryOpinionDTOS, Long companyInfoId) {
        List<SummaryOpinion> summaryOpinionList = new ArrayList<>();
        for (SummaryOpinionDTO summaryOpinionDTO : summaryOpinionDTOS) {
            SummaryOpinion summaryOpinion = new SummaryOpinion(summaryOpinionDTO);
            summaryOpinionList.add(summaryOpinion);
        }
        summaryOpinionRepository.saveAll(summaryOpinionList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<SummaryOpinionDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<SummaryOpinionDTO> summaryOpinionDTOS = new ArrayList<>();
        List<SummaryOpinion> summaryOpinionList = summaryOpinionRepository.findAllByCompanyInfoId(companyInfoId);
        for (SummaryOpinion summaryOpinion : summaryOpinionList) {
            SummaryOpinionDTO summaryOpinionDTO = new SummaryOpinionDTO(summaryOpinion);
            summaryOpinionDTOS.add(summaryOpinionDTO);
        }
        return summaryOpinionDTOS;
    }

    @Override
    public SummaryOpinionDTO create(SummaryOpinionDTO summaryOpinionDTO) throws ServiceException {
        return null;
    }

    @Override
    public SummaryOpinionDTO update(Long id, SummaryOpinionDTO summaryOpinionDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public SummaryOpinionDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<SummaryOpinionDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<SummaryOpinionDTO> findAll() {
        return null;
    }
}
