package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Bankers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BankersRepository extends JpaRepository<Bankers, Long> {

    List<Bankers> findAllByCompanyInfoId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from bankers b where b.company_info_id=?1",  nativeQuery = true)
    void deleteAllByCompanyInfoId(Long companyInfoId);
}
