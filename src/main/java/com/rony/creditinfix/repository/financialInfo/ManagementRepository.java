package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Management;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagementRepository extends JpaRepository<Management, Long> {

    List<Management> findAllByCompanyInfoId(Long id);
}
