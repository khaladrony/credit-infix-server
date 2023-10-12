package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.NatureOfBusiness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NatureOfBusinessRepository extends JpaRepository<NatureOfBusiness, Long> {

    List<NatureOfBusiness> findAllByCompanyInfoId(Long id);
}
