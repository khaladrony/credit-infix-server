package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.FinancialInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FinancialInformationRepository extends JpaRepository<FinancialInformation, Long> {

    List<FinancialInformation> findAllByCompanyInfoId(Long id);


    @Modifying
    @Transactional
    @Query(value = "delete from financial_information fi where fi.company_info_id=?1",  nativeQuery = true)
    void deleteAllByCompanyInfoId(Long companyInfoId);
}
