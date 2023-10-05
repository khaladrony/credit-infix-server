package com.rony.creditinfix.controllers;


import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.excel.ExcelService;
import com.rony.creditinfix.services.util.ExcelHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/excel")
public class ExcelUploadController {

    @Autowired
    ExcelService excelService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/financial-information", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadFinancialInformationFile(@RequestParam("file") MultipartFile file) {
        ApiResponse response = new ApiResponse();
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                response.setData(excelService.convertToFinancialInformationDTO(file));
                response.setMessage("File: [" + file.getOriginalFilename() + "] processed successfully");
                response.setSuccess(true);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } catch (Exception e) {
                response.setMessage(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }
        response.setMessage("Please upload an excel file!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @RequestMapping(value = "/shareholder", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadShareholderFile(@RequestParam("file") MultipartFile file) {
        ApiResponse response = new ApiResponse();
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                response.setData(excelService.convertToShareholderDTO(file));
                response.setMessage("File: [" + file.getOriginalFilename() + "] processed successfully");
                response.setSuccess(true);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } catch (Exception e) {
                response.setMessage(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }
        response.setMessage("Please upload an excel file!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @RequestMapping(value = "/management", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadManagementFile(@RequestParam("file") MultipartFile file) {
        ApiResponse response = new ApiResponse();
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                response.setData(excelService.convertToManagementDTO(file));
                response.setMessage("File: [" + file.getOriginalFilename() + "] processed successfully");
                response.setSuccess(true);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } catch (Exception e) {
                response.setMessage(e.getMessage());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }
        response.setMessage("Please upload an excel file!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
