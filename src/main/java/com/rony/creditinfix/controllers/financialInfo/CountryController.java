package com.rony.creditinfix.controllers.financialInfo;


import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.financialInfo.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/country")
public class CountryController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CountryService countryService;


    /**
     * Get All country list
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList() {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(countryService.findAll());
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * Get All country Risk Assessment
     *
     * @return
     */
    @RequestMapping(value = "/risk-assessment", method = RequestMethod.GET)
    public ResponseEntity<Object> getRiskAssessment(@RequestParam @Valid String countryName) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(countryService.getRiskAssessmentByCountryName(countryName));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
