package com.rony.creditinfix.repository.financialInfo;

import com.rony.creditinfix.entity.financialInfo.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "select * from country ",  nativeQuery = true)
    List<Country> getAllCountry();


    @Query(value = "select risk_assessment from country where name=?1",  nativeQuery = true)
    String getRiskAssessmentByCountryName(String name);
}
