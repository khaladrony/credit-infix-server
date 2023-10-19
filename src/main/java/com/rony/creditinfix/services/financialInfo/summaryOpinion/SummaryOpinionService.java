package com.rony.creditinfix.services.financialInfo.summaryOpinion;

import com.rony.creditinfix.models.financialInfo.SummaryOpinionDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface SummaryOpinionService extends AbstractService<SummaryOpinionDTO> {

    List<SummaryOpinionDTO> saveAll(List<SummaryOpinionDTO> summaryOpinionDTOS, Long companyInfoId);

    List<SummaryOpinionDTO> findAllByCompanyInfoId(Long companyInfoId);
}
