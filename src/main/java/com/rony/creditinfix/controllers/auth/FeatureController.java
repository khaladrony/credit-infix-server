package com.rony.creditinfix.controllers.auth;


import com.rony.creditinfix.controllers.ApiHandler;
import com.rony.creditinfix.models.auth.FeatureDTO;
import com.rony.creditinfix.services.auth.feature.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/features")
public class FeatureController {

    private final ApiHandler api;

    private final FeatureService featureService;


    /**
     * Create Feature
     *
     * @param featureDTO
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Object> login(@RequestParam(value = "featureDTO") String featureDTO) {
        FeatureDTO dto = api.parseDTO(featureDTO, FeatureDTO.class);

        return api.execute(() -> featureService.create(dto), "api.create.success");
    }


    /**
     * Update Feature
     *
     * @param featureDTO
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestParam(value = "featureDTO") String featureDTO) {
        FeatureDTO dto = api.parseDTO(featureDTO, FeatureDTO.class);

        return api.execute(() -> featureService.update(dto.getId(), dto), "api.update.success");
    }

    /**
     * Delete Feature
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        return api.execute(() -> featureService.delete(id), "api.delete.success");
    }


    /**
     * Get Feature list
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<Object> getList() {
        return api.execute(() -> featureService.findAll(), "api.list.success");
    }
}
