package com.rony.creditinfix.controllers.financialInfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.NatureOfBusinessDTO;
import com.rony.creditinfix.services.financialInfo.natureOfBusiness.NatureOfBusinessService;
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
@RequestMapping("/financial-info/nature-of-business")
public class NatureOfBusinessController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private NatureOfBusinessService natureOfBusinessService;


    /**
     * Create Nature Of Business List
     *
     * @param natureOfBusinessList
     * @param companyInfoId
     * @return
     */
    @PostMapping("/save")
    @ApiIgnore
    public ResponseEntity<Object> login(@RequestParam(value = "natureOfBusinessList") String natureOfBusinessList,
                                        @RequestParam(value = "companyInfoId") String companyInfoId,
                                        @RequestParam(value = "submitType") String submitType) {


        ApiResponse response = new ApiResponse(false);

        try {
            List<NatureOfBusinessDTO> reqModel = General.getObjectMapperWithDifferentProperty(natureOfBusinessList, new TypeReference<>() {
            });

            response.setData(natureOfBusinessService.saveAll(reqModel, Long.parseLong(companyInfoId)));
            response.setMessage(messageSource.getMessage(ApplicationConstant.SUBMIT_TYPE.equalsIgnoreCase(submitType) ? "api.update.success" : "api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Nature Of Business List
     *
     * @param companyInfoId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam @Valid Long companyInfoId) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(natureOfBusinessService.findAllByCompanyInfoId(companyInfoId));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    /**
     * Delete Nature Of Business
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(natureOfBusinessService.delete(id));
            response.setMessage(messageSource.getMessage("api.delete.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
