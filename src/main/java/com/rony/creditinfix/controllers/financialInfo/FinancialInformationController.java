package com.rony.creditinfix.controllers.financialInfo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.services.financialInfo.financialInformation.FinancialInformationService;
import com.rony.creditinfix.util.ApplicationConstant;
import com.rony.creditinfix.util.General;
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
@RequestMapping("/financial-info/financial-information")
public class FinancialInformationController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private FinancialInformationService financialInformationService;


    /**
     * Create Financial Information List
     *
     * @param financialInformationList
     * @param companyInfoId
     * @return
     */
    @PostMapping("/save")
    @ApiIgnore
    public ResponseEntity<Object> login(@RequestParam(value = "financialInformationList") String financialInformationList,
                                        @RequestParam(value = "companyInfoId") String companyInfoId,
                                        @RequestParam(value = "submitType") String submitType) {

        ApiResponse response = new ApiResponse(false);

        try {
            List<FinancialInformationDTO> reqModel = General.getObjectMapperWithDifferentProperty(financialInformationList, new TypeReference<>() {
            });

            response.setData(financialInformationService.saveAll(reqModel, Long.parseLong(companyInfoId)));
            response.setMessage(messageSource.getMessage(ApplicationConstant.SUBMIT_TYPE.equalsIgnoreCase(submitType) ? "api.update.success" : "api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Financial Information List
     *
     * @param companyInfoId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam @Valid Long companyInfoId) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(financialInformationService.findAllByCompanyInfoId(companyInfoId));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * Delete Financial Information
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(financialInformationService.delete(id));
            response.setMessage(messageSource.getMessage("api.delete.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}

