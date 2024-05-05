package com.rony.creditinfix.controllers.financialInfo;

import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.report.CompanyInfoReportGenerateDTO;
import com.rony.creditinfix.services.storedProcedure.CompanyInfoReportGenerateService;
import com.rony.creditinfix.util.XMLGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/xml-report-data")
public class ReportDataController {

    @Autowired
    CompanyInfoReportGenerateService companyInfoReportGenerateService;


    @RequestMapping(value = "/company-info", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> execute(@RequestParam("companyInfoId") Long companyInfoId) {
        ApiResponse response = new ApiResponse();

        try {
            CompanyInfoReportGenerateDTO dto =companyInfoReportGenerateService.execute(companyInfoId);
            response.setData(XMLGenerator.generateXML(dto));
//            response.setMessage("Stored procedure execute successfully");
//            response.setSuccess(true);

            return ResponseEntity.status(HttpStatus.OK).body(XMLGenerator.generateXML(dto));
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
