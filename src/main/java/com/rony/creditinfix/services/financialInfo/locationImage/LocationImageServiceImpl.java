package com.rony.creditinfix.services.financialInfo.locationImage;

import com.rony.creditinfix.entity.financialInfo.LocationImage;
import com.rony.creditinfix.models.financialInfo.LocationImageDTO;
import com.rony.creditinfix.repository.financialInfo.LocationImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImageServiceImpl implements LocationImageService {

    @Autowired
    LocationImageRepository locationImageRepository;

    @Override
    public LocationImageDTO findByCompanyInfoId(Long id) {
        return locationImageRepository.findByCompanyInfoId(id) == null ? null
                : new LocationImageDTO(locationImageRepository.findByCompanyInfoId(id));
    }

    @Override
    public LocationImageDTO findByNameAndCompanyInfoId(String name, Long id) {
        return new LocationImageDTO(locationImageRepository.findByNameAndCompanyInfoId(name, id));
    }

    @Override
    public LocationImageDTO create(LocationImageDTO locationImageDTO) {
        LocationImageDTO locationImageDTOExists = findByCompanyInfoId(locationImageDTO.getCompanyInfo().getId());
        if (locationImageDTOExists == null) {
            locationImageRepository.save(new LocationImage(locationImageDTO));
        } else {
            locationImageDTOExists.setName(locationImageDTO.getName());
            locationImageDTOExists.setType(locationImageDTO.getType());
            locationImageRepository.save(new LocationImage(locationImageDTOExists));
        }

        return locationImageDTO;
    }

    @Override
    public LocationImageDTO update(Long id, LocationImageDTO locationImageDTO) {
        locationImageRepository.save(new LocationImage(locationImageDTO));
        return locationImageDTO;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public LocationImageDTO findById(Long id) {
        return null;
    }

    @Override
    public Page<LocationImageDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<LocationImageDTO> findAll() {
        return null;
    }
}
