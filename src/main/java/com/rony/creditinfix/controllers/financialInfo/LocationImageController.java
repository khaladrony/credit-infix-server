package com.rony.creditinfix.controllers.financialInfo;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rony.creditinfix.entity.ImageUpload;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.ImageUploadDTO;
import com.rony.creditinfix.models.financialInfo.CompanyInfoDTO;
import com.rony.creditinfix.models.financialInfo.LocationImageDTO;
import com.rony.creditinfix.services.financialInfo.locationImage.LocationImageService;
import com.rony.creditinfix.util.General;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/location-image-path")
public class LocationImageController {

    @Autowired
    private LocationImageService locationImageService;

    @Autowired
    private MessageSource messageSource;


    @PostMapping("/save")
    public ResponseEntity<Object> saveImagePath(@RequestParam("locationImageDTO") String locationImageDTO) {
        ApiResponse response = new ApiResponse(false);

        try {
            LocationImageDTO reqModel = General.getObjectMapperWithDifferentProperty(locationImageDTO, LocationImageDTO.class);
            response.setData(locationImageService.create(reqModel));
            response.setMessage(messageSource.getMessage("api.image.upload.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getImage(@RequestParam(value = "companyInfoId") String companyInfoId) {

        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(locationImageService.findByCompanyInfoId(Long.parseLong(companyInfoId)));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
