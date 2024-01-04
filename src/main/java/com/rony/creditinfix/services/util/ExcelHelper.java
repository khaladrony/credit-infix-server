package com.rony.creditinfix.services.util;

import com.rony.creditinfix.models.financialInfo.FinancialInformationDTO;
import com.rony.creditinfix.models.financialInfo.ManagementDTO;
import com.rony.creditinfix.models.financialInfo.ShareholderDTO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class ExcelHelper {

    private static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private XSSFWorkbook workbook;

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    private boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }

        return true;
    }


    private boolean isValueEmptyOrNA(String string) {
        return (string.equals("") || string.equalsIgnoreCase("N/A") || string.equalsIgnoreCase("N\\A")
                || string.equalsIgnoreCase("NA") || string.equalsIgnoreCase("N A"));
    }

    private boolean isValueNumeric(String string) {
        if (string.startsWith("0"))
            return false;

        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
            return false;
        }
    }

    private String getCellValueString(Cell cell) {
        if (cell.getCellType().equals(CellType.NUMERIC)) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

    public List<FinancialInformationDTO> excelToFinancialInformationDTO(InputStream is) {
        try {
            workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<FinancialInformationDTO> financialInformationDTOs = new ArrayList<FinancialInformationDTO>();
            FinancialInformationDTO financialInformationDTO = null;


            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cellIterator = row.iterator();
                int cid = 0;
                financialInformationDTO = new FinancialInformationDTO();
                DataFormatter dataFormatter = new DataFormatter();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    System.out.println(dataFormatter.formatCellValue(cell));
                    switch (cid) {
                        case 0:
                            financialInformationDTO.setItemCode(cell.getStringCellValue());
                            break;
                        case 1:
                            financialInformationDTO.setThirdYear(dataFormatter.formatCellValue(cell));
                            break;
                        case 2:
                            financialInformationDTO.setSecondYear(dataFormatter.formatCellValue(cell));
                            break;
                        case 3:
                            financialInformationDTO.setFirstYear(dataFormatter.formatCellValue(cell));
                            break;
                        default:
                            break;
                    }
                    cid++;
                }

                /*
                 * Display the data in the 'Year' column of the table without any decimal places
                 * */
                if (financialInformationDTO.getItemCode().equalsIgnoreCase("Year")) {
                    financialInformationDTO.setThirdYear(financialInformationDTO.getThirdYear().substring(0, 4));
                    financialInformationDTO.setSecondYear(financialInformationDTO.getSecondYear().substring(0, 4));
                    financialInformationDTO.setFirstYear(financialInformationDTO.getFirstYear().substring(0, 4));
                }

                financialInformationDTOs.add(financialInformationDTO);
            }

            workbook.close();

            return financialInformationDTOs;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    public List<ShareholderDTO> excelToShareholderDTO(InputStream is) {
        try {
            workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            Row headerRow = null;

            List<ShareholderDTO> shareholderDTOs = new ArrayList<ShareholderDTO>();
            ShareholderDTO shareholderDTO = null;


            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cellIterator = row.iterator();
                int i = 0;

                if (row.getRowNum() == 0) {
                    headerRow = row;
                }

                while (headerRow != null && cellIterator.hasNext() && row.getRowNum() > 0) {
                    Cell cell = cellIterator.next();

                    shareholderDTO = new ShareholderDTO();
                    shareholderDTO.setItemCode(headerRow.getCell(i).getStringCellValue());
                    shareholderDTO.setItemValue(getCellValueString(cell));
                    shareholderDTO.setSequence(i + 1);
                    shareholderDTOs.add(shareholderDTO);

                    i++;
                }
            }

            workbook.close();

            return shareholderDTOs;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<ManagementDTO> excelToManagementDTO(InputStream is) {
        try {
            workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            Row headerRow = null;

            List<ManagementDTO> managementDTOs = new ArrayList<>();
            ManagementDTO managementDTO = null;

            while (rows.hasNext()) {
                Row row = rows.next();
                Iterator<Cell> cellIterator = row.iterator();
                int i = 0;

                if (row.getRowNum() == 0) {
                    headerRow = row;
                }

                while (headerRow != null && cellIterator.hasNext() && row.getRowNum() > 0) {
                    Cell cell = cellIterator.next();

                    managementDTO = new ManagementDTO();
                    managementDTO.setItemCode(headerRow.getCell(i).getStringCellValue());
                    managementDTO.setItemValue(getCellValueString(cell));
                    managementDTO.setSequence(i + 1);
                    managementDTOs.add(managementDTO);

                    i++;
                }
            }

            workbook.close();

            return managementDTOs;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


}
