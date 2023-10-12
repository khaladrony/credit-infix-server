package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.CorporateStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorporateStructureRepository extends JpaRepository<CorporateStructure, Long> {

    List<CorporateStructure> findAllByCompanyInfoId(Long id);
}
