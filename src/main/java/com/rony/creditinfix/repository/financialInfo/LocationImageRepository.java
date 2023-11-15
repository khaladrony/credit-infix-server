package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationImageRepository extends JpaRepository<LocationImage, Long> {

    LocationImage findByCompanyInfoId(Long id);

    LocationImage findByNameAndCompanyInfoId(String name, Long id);
}