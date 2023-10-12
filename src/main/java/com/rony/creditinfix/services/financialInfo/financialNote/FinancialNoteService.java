package com.rony.creditinfix.services.financialInfo.financialNote;

import com.rony.creditinfix.models.financialInfo.FinancialNoteDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface FinancialNoteService extends AbstractService<FinancialNoteDTO> {

    List<FinancialNoteDTO> saveAll(List<FinancialNoteDTO> financialNoteDTOS, Long companyInfoId);

    List<FinancialNoteDTO> findAllByCompanyInfoId(Long companyInfoId);

}
