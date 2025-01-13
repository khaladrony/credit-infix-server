package com.rony.creditinfix.controllers.financialInfo;


import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.CompanyInfoDTO;
import com.rony.creditinfix.services.financialInfo.companyInfo.CompanyInfoService;
import com.rony.creditinfix.util.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/company-info")
public class CompanyInfoController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CompanyInfoService companyInfoService;

    /**
     * Create Company Info
     *
     * @param companyInfoDTO
     * @return
     */
    @PostMapping("/add")
    @ApiIgnore
    public ResponseEntity<Object> save(@RequestParam(value = "companyInfoDTO") String companyInfoDTO) {

        ApiResponse response = new ApiResponse(false);

        try {
//            ObjectMapper mapper = new ObjectMapper();
//            CompanyInfoDTO reqModel = mapper.readValue(companyInfoDTO, CompanyInfoDTO.class);
            CompanyInfoDTO reqModel = General.getObjectMapperWithDifferentProperty(companyInfoDTO, CompanyInfoDTO.class);
            response.setData(companyInfoService.create(reqModel));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Update Company Info
     *
     * @param companyInfoDTO
     * @return
     */
    @PutMapping(value = "/update")
    @ApiIgnore
    public ResponseEntity<Object> update(@RequestParam(value = "companyInfoDTO") String companyInfoDTO) {
        ApiResponse response = new ApiResponse();
        try {
            CompanyInfoDTO reqModel = General.getObjectMapperWithDifferentProperty(companyInfoDTO, CompanyInfoDTO.class);
            if (reqModel.getId() != null) {
                response.setData(companyInfoService.update(reqModel.getId(), reqModel));
                response.setMessage(messageSource.getMessage("api.update.success", null, null));
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.setMessage("Project ID not found!");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * Delete Company Info
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    @ApiIgnore
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(companyInfoService.delete(id));
            response.setMessage(messageSource.getMessage("api.delete.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Company Info list
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getList() {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(companyInfoService.findAll());
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
