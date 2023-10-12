package com.rony.creditinfix.services.financialInfo.financialNote;

import com.rony.creditinfix.entity.financialInfo.FinancialNote;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.FinancialNoteDTO;
import com.rony.creditinfix.repository.financialInfo.FinancialNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FinancialNoteImpl implements FinancialNoteService {

    @Autowired
    private FinancialNoteRepository financialNoteRepository;

    @Override
    public List<FinancialNoteDTO> saveAll(List<FinancialNoteDTO> financialNoteDTOS, Long companyInfoId) {
        List<FinancialNote> financialNoteList = new ArrayList<>();
        for (FinancialNoteDTO financialNoteDTO : financialNoteDTOS) {
            FinancialNote financialNote = new FinancialNote(financialNoteDTO);
            financialNoteList.add(financialNote);
        }
        financialNoteRepository.saveAll(financialNoteList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<FinancialNoteDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<FinancialNoteDTO> financialNoteDTOS = new ArrayList<>();
        List<FinancialNote> financialNoteList = financialNoteRepository.findAllByCompanyInfoId(companyInfoId);
        for (FinancialNote financialNote : financialNoteList) {
            FinancialNoteDTO financialNoteDTO = new FinancialNoteDTO(financialNote);
            financialNoteDTOS.add(financialNoteDTO);
        }
        return financialNoteDTOS;
    }

    @Override
    public FinancialNoteDTO create(FinancialNoteDTO financialNoteDTO) throws ServiceException {
        return null;
    }

    @Override
    public FinancialNoteDTO update(Long id, FinancialNoteDTO financialNoteDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public FinancialNoteDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<FinancialNoteDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<FinancialNoteDTO> findAll() {
        return null;
    }
}
