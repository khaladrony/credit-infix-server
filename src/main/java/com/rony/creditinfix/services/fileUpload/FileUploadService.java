package com.rony.creditinfix.services.fileUpload;

import com.rony.creditinfix.exception.ServiceException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileUploadService {

    String FILE_UPLOAD_DIRECTORY_NAME = "uploads";
    String FILE_FORMATS_DIRECTORY_NAME = "formats";

    String uploadSingleFile(MultipartFile file, String prefix) throws ServiceException;

    File getUploadFileByFileName(String fileName);

    Resource viewFile(String filePath, String fileName) throws ServiceException;
}
