package com.rony.creditinfix.services.fileUpload;

import com.rony.creditinfix.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileUploadServiceImpl implements FileUploadService {
    private final Path root;

    public FileUploadServiceImpl(@Value("${upload.path}") String defaultLocation) {

        root = Paths.get(defaultLocation).toAbsolutePath().normalize();

        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Cannot creating file directory");
        }
    }


    @Override
    public String uploadSingleFile(MultipartFile file, String prefix) throws ServiceException {
        String filePath;
        if (prefix == null) {
            prefix = "";
        }
        Path path = Paths.get(this.root + File.separator + FileUploadService.FILE_UPLOAD_DIRECTORY_NAME);
        try {

            if (Files.notExists(path)) {
                Files.createDirectory(path);
            }

            filePath = FileUploadService.FILE_UPLOAD_DIRECTORY_NAME + File.separator + prefix + file.getOriginalFilename();
//            Files.deleteIfExists(Paths.get(filePath));

            Files.copy(file.getInputStream(), path.resolve(prefix + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }

        return filePath;
    }

    @Override
    public File getUploadFileByFileName(String fileName) {
        Path path = Paths.get(this.root + File.separator + FileUploadService.FILE_UPLOAD_DIRECTORY_NAME)
                .toAbsolutePath().resolve(fileName);

        File attachmentFile = path.toFile();

        return attachmentFile;
    }

    @Override
    public Resource viewFile(String filePath, String fileName) throws ServiceException {
        Path path = Paths.get(this.root + File.separator + filePath)
                .toAbsolutePath().resolve(fileName);

        Resource resource;

        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException("The file can't be reading.");
        }

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("The file doesn't exist.");
        }
    }
}
