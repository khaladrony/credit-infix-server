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

    @RequestMapping(value = "/excel-upload", method = RequestMethod.POST)
    public ResponseEntity<Object> uploadBkashFile(@RequestParam("file") MultipartFile file, @RequestParam("category") String category,
                                                  @RequestParam("commission") Double commission, @RequestParam("particulars") String particulars) {
        ApiResponse response = new ApiResponse();
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                response.setData(excelService.convertToModel(file, category, commission, particulars));
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
