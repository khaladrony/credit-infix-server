package com.rony.creditinfix.services.financialInfo.country;

import com.rony.creditinfix.entity.financialInfo.Country;
import com.rony.creditinfix.models.financialInfo.CountryDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface CountryService extends AbstractService<CountryDTO> {

    List<Country> getAllCountry();

    String getRiskAssessmentByCountryName(String name);
}
