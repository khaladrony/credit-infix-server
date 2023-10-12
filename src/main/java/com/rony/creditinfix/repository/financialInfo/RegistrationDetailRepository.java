package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.RegistrationDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationDetailRepository extends JpaRepository<RegistrationDetail, Long> {

    List<RegistrationDetail> findAllByCompanyInfoId(Long id);
}
