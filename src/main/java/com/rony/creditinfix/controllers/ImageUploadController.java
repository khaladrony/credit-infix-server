package com.rony.creditinfix.controllers;


import com.rony.creditinfix.entity.ImageUpload;
import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.models.ImageUploadDTO;
import com.rony.creditinfix.services.imageUpload.ImageUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/image")
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;
    @Autowired
    private MessageSource messageSource;


    @PostMapping("/upload")
    public ResponseEntity<Object>  uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException, ServiceException {
        ApiResponse response = new ApiResponse(false);

        try {
            log.info("Original Image Byte Size - " + file.getBytes().length);
            ImageUploadDTO img = new ImageUploadDTO(file.getOriginalFilename(), file.getContentType(),
                    imageUploadService.compressBytes(file.getBytes()));


            response.setData(imageUploadService.create(img));
            response.setMessage(messageSource.getMessage("api.image.upload.success", null, null));
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping(path = {"/get/{imageName}"})
    public ImageUpload getImage(@PathVariable("imageName") String imageName) throws IOException {

        final Optional<ImageUpload> retrievedImage = imageUploadService.findByName(imageName);
        ImageUpload img = new ImageUpload(retrievedImage.get().getName(), retrievedImage.get().getType(),
                imageUploadService.decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }


}
