package com.rony.creditinfix.services.financialInfo.location;

import com.rony.creditinfix.models.financialInfo.LocationDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.List;

public interface LocationService extends AbstractService<LocationDTO> {

    List<LocationDTO> saveAll(List<LocationDTO> locationDTOS, Long companyInfoId);

    List<LocationDTO> findAllByCompanyInfoId(Long companyInfoId);
}
