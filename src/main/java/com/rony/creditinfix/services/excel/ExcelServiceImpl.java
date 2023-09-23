package com.rony.creditinfix.services.excel;

import com.rony.creditinfix.models.ExcelResponseModel;
import com.rony.creditinfix.models.ImportedFileDetailsListModel;
import com.rony.creditinfix.services.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    ExcelHelper excelHelper;


    Boolean invalidStatus = false;


    @Override
    public ImportedFileDetailsListModel convertToModel(MultipartFile file, String category, Double commission, String particulars) {
        List<ExcelResponseModel> moneyDetailsModels = null;
        try {
            moneyDetailsModels = excelHelper.excelToModel(file.getInputStream(), category, commission, particulars);

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

//        ImportedFileDetailsListBkashModel importedFileDetailsListBkashModel = new ImportedFileDetailsListBkashModel();
//        importedFileDetailsListBkashModel.setResponseModels(moneyDetailsModels);
//        importedFileDetailsListBkashModel.setInvalidExists(invalidStatus);
        invalidStatus = false;

        return null;
    }




}
