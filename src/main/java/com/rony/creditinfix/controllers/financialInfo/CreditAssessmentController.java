package com.rony.creditinfix.controllers.financialInfo;


import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.financialInfo.creditAssessment.CreditAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/credit-assessment")
public class CreditAssessmentController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CreditAssessmentService creditAssessmentService;

    /**
     * Get Credit Assessment info
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity<Object> getInfo(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(creditAssessmentService.getDate(id));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}


