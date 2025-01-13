package com.rony.creditinfix.controllers.financialInfo;

import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.ContactDTO;
import com.rony.creditinfix.services.financialInfo.contact.ContactService;
import com.rony.creditinfix.util.General;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/financial-info/contact")
public class ContactController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ContactService contactService;


    /**
     * Create Contact
     *
     * @param contactDTO
     * @return
     */
    @PostMapping("/add")
    @ApiIgnore
    public ResponseEntity<Object> login(@RequestParam(value = "contactDTO") String contactDTO) {

        ApiResponse response = new ApiResponse(false);

        try {
            ContactDTO reqModel = General.getObjectMapperWithDifferentProperty(contactDTO, ContactDTO.class);
            response.setData(contactService.create(reqModel));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Update Contact
     *
     * @param contactDTO
     * @return
     */
    @PutMapping(value = "/update")
    @ApiIgnore
    public ResponseEntity<Object> update(@RequestParam(value = "contactDTO") String contactDTO) {
        ApiResponse response = new ApiResponse();
        try {
            ContactDTO reqModel = General.getObjectMapperWithDifferentProperty(contactDTO, ContactDTO.class);
            if (reqModel.getId() != null) {
                response.setData(contactService.update(reqModel.getId(), reqModel));
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
     * Get Contact List
     *
     * @param companyInfoId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam @Valid Long companyInfoId) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(contactService.findAllByCompanyInfoId(companyInfoId));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
