package com.rony.creditinfix.controllers.financialInfo;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import com.rony.creditinfix.services.financialInfo.shareholder.ShareholderService;
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
@RequestMapping("/financial-info/shareholder")
public class ShareholderController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ShareholderService shareholderService;



    /**
     * Create Shareholder List
     *
     * @param shareholderList
     * @param companyInfoId
     * @return
     */
    @PostMapping("/save")
    @ApiIgnore
    public ResponseEntity<Object> login(@RequestParam(value = "shareholderList") String shareholderList,
                                        @RequestParam(value = "companyInfoId") String companyInfoId) {

        ApiResponse response = new ApiResponse(false);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            List<ShareholderDTO> reqModel =
                    mapper.readValue(shareholderList, new TypeReference<List<ShareholderDTO>>() {
                    });

            response.setData(shareholderService.saveAll(reqModel, Long.parseLong(companyInfoId)));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Shareholder List
     *
     * @param companyInfoId
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getList(@RequestParam @Valid Long companyInfoId) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(shareholderService.findAllByCompanyInfoId(companyInfoId));
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
