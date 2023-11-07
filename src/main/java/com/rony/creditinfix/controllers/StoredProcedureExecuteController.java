package com.rony.creditinfix.controllers;

import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.storedProcedure.StoredProcedureExecuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/stored-procedure-execute")
public class StoredProcedureExecuteController {

    @Autowired
    StoredProcedureExecuteService storedProcedureExecuteService;


    @RequestMapping(value = "/data-insert", method = RequestMethod.POST)
    public ResponseEntity<Object> execute(@RequestParam("templateName") String templateName,
                                          @RequestParam("companyInfoId") Long companyInfoId) {
        ApiResponse response = new ApiResponse();

        try {
            response.setData(storedProcedureExecuteService.execute(templateName, companyInfoId));
            response.setMessage("Stored procedure execute successfully");
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
