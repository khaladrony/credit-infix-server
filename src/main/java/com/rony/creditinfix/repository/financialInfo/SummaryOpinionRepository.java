package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.SummaryOpinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryOpinionRepository extends JpaRepository<SummaryOpinion, Long> {

    List<SummaryOpinion> findAllByCompanyInfoId(Long id);
}
