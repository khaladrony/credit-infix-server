package com.rony.creditinfix.services.financialInfo.locationImage;

import com.rony.creditinfix.entity.financialInfo.LocationImage;
import com.rony.creditinfix.models.financialInfo.LocationImageDTO;
import com.rony.creditinfix.services.AbstractService;

import java.util.Optional;

public interface LocationImageService  extends AbstractService<LocationImageDTO> {

    LocationImageDTO findByCompanyInfoId(Long id);

    LocationImageDTO findByNameAndCompanyInfoId(String name, Long id);

}
