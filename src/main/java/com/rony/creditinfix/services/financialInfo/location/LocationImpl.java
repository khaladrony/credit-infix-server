package com.rony.creditinfix.services.financialInfo.location;


import com.rony.creditinfix.entity.financialInfo.Location;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.financialInfo.LocationDTO;
import com.rony.creditinfix.repository.financialInfo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public List<LocationDTO> saveAll(List<LocationDTO> locationDTOS, Long companyInfoId) {
        List<Location> locationList = new ArrayList<>();
        for (LocationDTO locationDTO : locationDTOS) {
            Location location = new Location(locationDTO);
            locationList.add(location);
        }
        locationRepository.saveAll(locationList);
        return this.findAllByCompanyInfoId(companyInfoId);
    }

    @Override
    public List<LocationDTO> findAllByCompanyInfoId(Long companyInfoId) {
        List<LocationDTO> locationDTOS = new ArrayList<>();
        List<Location> locationList = locationRepository.findAllByCompanyInfoId(companyInfoId);
        for (Location location : locationList) {
            LocationDTO locationDTO = new LocationDTO(location);
            locationDTOS.add(locationDTO);
        }
        return locationDTOS;
    }

    @Override
    public LocationDTO create(LocationDTO locationDTO) throws ServiceException {
        return null;
    }

    @Override
    public LocationDTO update(Long id, LocationDTO locationDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(Long id) throws ServiceException {
        return null;
    }

    @Override
    public LocationDTO findById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public Page<LocationDTO> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<LocationDTO> findAll() {
        return null;
    }
}
