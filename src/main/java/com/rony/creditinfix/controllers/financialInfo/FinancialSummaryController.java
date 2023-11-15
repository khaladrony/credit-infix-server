package com.rony.creditinfix.controllers.financialInfo;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.FinancialSummaryDTO;
import com.rony.creditinfix.services.financialInfo.financialSummary.FinancialSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/financial-summary")
public class FinancialSummaryController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private FinancialSummaryService financialSummaryService;


    /**
     * Create Financial Summary
     *
     * @param financialSummaryList
     * @param companyInfoId
     * @return
     */
    @PostMapping("/save")
    @ApiIgnore
    public ResponseEntity<Object> login(@RequestParam(value = "financialSummaryList") String financialSummaryList,
                                        @RequestParam(value = "companyInfoId") String companyInfoId) {

        ApiResponse response = new ApiResponse(false);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            List<FinancialSummaryDTO> reqModel = mapper.readValue(financialSummaryList, new TypeReference<List<FinancialSummaryDTO>>() {
            });

            response.setData(financialSummaryService.saveAll(reqModel, Long.parseLong(companyInfoId)));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Financial Summary
     *
     * @param companyInfoId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam @Valid Long companyInfoId) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(financialSummaryService.findAllByCompanyInfoId(companyInfoId));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * Delete Financial Summary
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(financialSummaryService.delete(id));
            response.setMessage(messageSource.getMessage("api.delete.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
