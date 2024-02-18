package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ManagementRepository extends JpaRepository<Management, Long> {

    List<Management> findAllByCompanyInfoId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from management m where m.company_info_id=?1",  nativeQuery = true)
    void deleteAllByCompanyInfoId(Long companyInfoId);
}
