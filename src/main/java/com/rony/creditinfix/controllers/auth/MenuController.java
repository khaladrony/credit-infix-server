package com.rony.creditinfix.controllers.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.auth.MenuDTO;
import com.rony.creditinfix.services.auth.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private MenuService menuService;


    /**
     * Create Menu
     *
     * @param menuDTO
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Object> login(@RequestParam(value = "menuDTO") String menuDTO) {

        ApiResponse response = new ApiResponse(false);

        try {
            ObjectMapper mapper = new ObjectMapper();
            MenuDTO reqModel = mapper.readValue(menuDTO, MenuDTO.class);
            response.setData(menuService.create(reqModel));
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Update Menu
     *
     * @param menuDTO
     * @return
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestParam(value = "menuDTO") String menuDTO) {
        ApiResponse response = new ApiResponse();
        try {
            ObjectMapper mapper = new ObjectMapper();
            MenuDTO reqModel = mapper.readValue(menuDTO, MenuDTO.class);
            if (reqModel.getId() != null) {
                response.setData(menuService.update(reqModel.getId(), reqModel));
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
     * Delete Menu
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam @Valid Long id) {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(menuService.delete(id));
            response.setMessage(messageSource.getMessage("api.delete.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    /**
     * Get Menu list
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<Object> getList() {
        ApiResponse response = new ApiResponse(false);
        try {
            response.setData(menuService.findAll());
            response.setMessage(messageSource.getMessage("api.list.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
