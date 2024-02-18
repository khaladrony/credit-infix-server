package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {

    List<Shareholder> findAllByCompanyInfoId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from shareholder sh where sh.company_info_id=?1",  nativeQuery = true)
    void deleteAllByCompanyInfoId(Long companyInfoId);
}
