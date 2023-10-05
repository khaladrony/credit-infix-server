package com.rony.creditinfix.services.excel;

import com.rony.creditinfix.models.ExcelResponseDTO;
import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
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


    @Override
    public ExcelResponseDTO convertToFinancialInformationDTO(MultipartFile file) {
        List<FinancialInformationDTO> financialInformationDTOs = null;
        try {
            financialInformationDTOs = excelHelper.excelToFinancialInformationDTO(file.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        ExcelResponseDTO excelResponseDTO = new ExcelResponseDTO();
        excelResponseDTO.setResponseDTOs(financialInformationDTOs);

        return excelResponseDTO;
    }


    @Override
    public ExcelResponseDTO convertToShareholderDTO(MultipartFile file) {
        List<ShareholderDTO> shareholderDTOs = null;
        try {
            shareholderDTOs = excelHelper.excelToShareholderDTO(file.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        ExcelResponseDTO excelResponseDTO = new ExcelResponseDTO();
        excelResponseDTO.setResponseDTOs(shareholderDTOs);

        return excelResponseDTO;
    }

    @Override
    public ExcelResponseDTO convertToManagementDTO(MultipartFile file) {
        List<ManagementDTO> managementDTOs = null;
        try {
            managementDTOs = excelHelper.excelToManagementDTO(file.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        ExcelResponseDTO excelResponseDTO = new ExcelResponseDTO();
        excelResponseDTO.setResponseDTOs(managementDTOs);

        return excelResponseDTO;
    }



}
