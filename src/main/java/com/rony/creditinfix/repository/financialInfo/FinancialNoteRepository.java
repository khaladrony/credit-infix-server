package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.FinancialNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialNoteRepository extends JpaRepository<FinancialNote, Long> {

    List<FinancialNote> findAllByCompanyInfoId(Long id);
}
