package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.OperationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationInfoRepository extends JpaRepository<OperationInfo, Long> {

    List<OperationInfo> findAllByCompanyInfoId(Long id);
}


