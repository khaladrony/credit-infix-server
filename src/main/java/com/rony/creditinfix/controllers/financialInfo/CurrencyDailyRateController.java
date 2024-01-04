package com.rony.creditinfix.controllers.financialInfo;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.CurrencyDailyRateDTO;
import com.rony.creditinfix.services.financialInfo.currencyDailyRate.CurrencyDailyRateService;
import com.rony.creditinfix.util.AppDate;
import com.rony.creditinfix.util.DateUtil;
import com.rony.creditinfix.util.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/currency-daily-rate")
public class CurrencyDailyRateController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CurrencyDailyRateService currencyDailyRateService;


    /**
     * Create Currency Daily Rate List
     *
     * @param currencyDailyRateList
     * @param currencyDate
     * @return
     */
    @PostMapping("/save")
    @ApiIgnore
    public ResponseEntity<Object> save(@RequestParam(value = "currencyDailyRateList") String currencyDailyRateList,
                                       @RequestParam(value = "currencyDate") Date currencyDate) {

        ApiResponse response = new ApiResponse(false);

        try {
            List<CurrencyDailyRateDTO> reqModel = General.getObjectMapperWithDifferentProperty(currencyDailyRateList, new TypeReference<>() {
            });

            response.setData(currencyDailyRateService.saveAll(reqModel,currencyDate));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Currency Daily Rate List
     *
     * @param currencyDate
     * @return
     */
    @RequestMapping(value = "/list-by-date", method = RequestMethod.GET)
    public ResponseEntity<Object> getListByCurrencyDate(@RequestParam @Valid Date currencyDate) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(currencyDailyRateService.findAllByCurrencyDate(currencyDate));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get All Currency Daily Rate List
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList() {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(currencyDailyRateService.findAll());
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
