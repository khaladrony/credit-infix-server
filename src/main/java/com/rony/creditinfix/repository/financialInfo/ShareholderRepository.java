package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {

    List<Shareholder> findAllByCompanyInfoId(Long id);
}
