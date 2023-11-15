package com.rony.creditinfix.controllers;


import com.rony.creditinfix.exception.ServiceException;
import com.rony.creditinfix.models.ApiResponse;
import com.rony.creditinfix.services.fileUpload.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/file-upload")
public class FileUploadController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    FileUploadService fileUploadService;

    @PostMapping(value = "/image", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> imageUpload(@RequestPart("file") MultipartFile file) throws ServiceException {

        log.info("handling request parts: {}", file);
        ApiResponse response = new ApiResponse(false);

        try {

            String path = fileUploadService.uploadSingleFile(file, "");
            Map map = new HashMap();
            map.put("filename", file.getOriginalFilename());
            map.put("fileUri", path);

            response.setData(map);
            response.setMessage(messageSource.getMessage("api.image.upload.success", null, null));
            response.setSuccess(true);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/file", consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> handleFileUploadForm(@RequestPart("file") MultipartFile file) throws IOException {

        log.info("handling request parts: {}", file);
        ApiResponse response = new ApiResponse(false);

        try {

            File f = new ClassPathResource("").getFile();
            final Path path = Paths.get(f.getAbsolutePath() + File.separator + "static" + File.separator + "image");

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/image/")
                    .path(file.getOriginalFilename())
                    .toUriString();

//            Map result = Map.of(
//                    "filename", file.getOriginalFilename(),
//                    "fileUri", fileUri
//            );

            Map map = new HashMap();
            map.put("filename", file.getOriginalFilename());
            map.put("fileUri", fileUri);

            response.setData(map);
            response.setMessage(messageSource.getMessage("api.create.success", null, null));
            response.setSuccess(true);

            return ResponseEntity.status(HttpStatus.OK).body(response);


        } catch (IOException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "/image-preview", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadUploadedFile(@RequestParam("fileName") String fileName) {
        ApiResponse response = new ApiResponse(false);
        Resource resource = null;
        String mimeType;

        try {
            resource = fileUploadService.viewFile("", fileName);
        } catch (ServiceException e) {
            System.err.println(e.getMessage());
        }
        mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;


        assert resource != null;
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName=" + resource.getFilename())
                .body(resource);
    }
}
