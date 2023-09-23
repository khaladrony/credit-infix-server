package com.rony.creditinfix.services.excel;


import com.rony.creditinfix.models.ImportedFileDetailsListModel;
import org.springframework.web.multipart.MultipartFile;


public interface ExcelService {

    ImportedFileDetailsListModel convertToModel(MultipartFile file, String category, Double commission, String particulars);

}
