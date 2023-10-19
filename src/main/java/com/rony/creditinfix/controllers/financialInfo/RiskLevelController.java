package com.rony.creditinfix.controllers.financialInfo;

import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.financialInfo.riskLevel.RiskLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/risk-level")
public class RiskLevelController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private RiskLevelService riskLevelService;


    /**
     * Get Risk Level list
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList() {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(riskLevelService.findAll());
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
