package com.rony.creditinfix.services.financialInfo.country;

import com.rony.creditinfix.entity.financialInfo.Country;
import com.rony.creditinfix.models.financialInfo.CountryDTO;
import com.rony.creditinfix.repository.financialInfo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.getAllCountry();
    }

    @Override
    public String getRiskAssessmentByCountryName(String name) {
        return countryRepository.getRiskAssessmentByCountryName(name);
    }

    @Override
    public CountryDTO create(CountryDTO countryDTO) {
        return null;
    }

    @Override
    public CountryDTO update(Long id, CountryDTO countryDTO) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public CountryDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<CountryDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CountryDTO> findAll() {
        List<CountryDTO> countryDTOS = new ArrayList<>();
        List<Country> countryList = countryRepository.findAll();
        for (Country country : countryList) {
            country.setRiskAssessment("");
            CountryDTO countryDTO = new CountryDTO(country);
            countryDTOS.add(countryDTO);
        }

        return countryDTOS.stream()
                .sorted(Comparator.comparing(CountryDTO::getName))
                .collect(Collectors.toList());
    }
}
