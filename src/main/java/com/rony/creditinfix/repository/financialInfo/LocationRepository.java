package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findAllByCompanyInfoId(Long id);
}
