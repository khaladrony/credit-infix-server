package com.rony.creditinfix.services.excel;


import com.rony.creditinfix.models.ExcelResponseDTO;
import org.springframework.web.multipart.MultipartFile;


public interface ExcelService {

    ExcelResponseDTO convertToFinancialInformationDTO(MultipartFile file);

    ExcelResponseDTO convertToShareholderDTO(MultipartFile file);

    ExcelResponseDTO convertToManagementDTO(MultipartFile file);

}
