package com.rony.creditinfix.services.util;

import com.rony.creditinfix.models.ExcelResponseModel;
import com.rony.creditinfix.services.excel.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;


@Component
public class ExcelHelper {

//    @Autowired
//    ExcelService excelService;

    private static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    private XSSFWorkbook workbook;

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }





    public List<ExcelResponseModel> excelToModel(InputStream is, String category, Double commission, String particulars) {
        try {
            workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<Integer> listOfInvalidAmnt = new ArrayList<>();
            List<String> invalidAreaCodeList = new ArrayList<>();
            List<Map> invalidAreaCodeMapList = new ArrayList<>();
            List<ExcelResponseModel> bkashMoneyDetailsModels = new ArrayList<ExcelResponseModel>();
            ExcelResponseModel bkashMoneyDetailsModel = null;

            double commissionAmount;
            int slNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (currentRow.getRowNum() == 0) {
                    if (currentRow.getLastCellNum() != 2 || isRowEmpty(currentRow)) {
                        throw new RuntimeException("Invalid Excel file for Bkash Money. \nPlease provide Area Code, Amount Only.");
                    }
                    continue;
                }
                // check if any row data deleted or row is empty
                if (currentRow.getLastCellNum() < 0 || isRowEmpty(currentRow)) {
                    break;
                }

                Cell currentCell;

                if (currentRow.getCell(1) != null) {
                    currentCell = currentRow.getCell(1);
                    currentCell.setCellType(CellType.NUMERIC);

                    if (currentCell.getNumericCellValue() <= 0) {
                        listOfInvalidAmnt.add((currentRow.getRowNum() + 1));
                    }

                } else {
                    listOfInvalidAmnt.add((currentRow.getRowNum() + 1));
                    throw new RuntimeException("Invalid Amount at row no: [" + (currentRow.getRowNum() + 1) + "]");
                }
            }

            if (listOfInvalidAmnt.size() > 0) {
                throw new RuntimeException("Invalid Amount at row no: [" + String.join(listOfInvalidAmnt.toString(), ",") + "]");
            }

            rows = sheet.iterator();
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (currentRow.getRowNum() == 0) {
                    if (currentRow.getLastCellNum() != 2 || isRowEmpty(currentRow)) {
                        throw new RuntimeException("Invalid Excel file for Bkash Money. \nPlease provide Area Code, Amount Only.");
                    }
                    continue;
                }
                // check if any row data deleted or row is empty
                if (currentRow.getLastCellNum() < 0 || isRowEmpty(currentRow)) {
                    break;
                }

                bkashMoneyDetailsModel = new ExcelResponseModel();

                Cell currentCell = null;

                /*if (currentRow.getCell(0) != null) {
                    currentCell = currentRow.getCell(0);
                    currentCell.setCellType(CellType.STRING);

                    String cellValue = currentCell.getStringCellValue();

                    if (cellValue.length() == 8 || cellValue.length() == 9) {
                        projectSetup = projectSetupService.findByProjectRefCode(cellValue.substring(0, cellValue.length() - 5));
                        if (projectSetup == null) {
                            throw new RuntimeException("Invalid Project Code at row no: [" + (currentRow.getRowNum() + 1) + "]");
                        } else {
                            if (!projectSetup.getCategory().equalsIgnoreCase(category)) {
                                throw new RuntimeException("Project Code must be of Same category as selected at row no: [" + (currentRow.getRowNum() + 1) + "]");
                            }
                        }

                        areaCode = areaCurrentAccountCodeService.findByAreaCurrentAcCode(cellValue);
                        if (areaCode == null) {
                            // sort out invalid area code
                            invalidAreaCodeList.add(cellValue);

                            invalidAreaCodeMap.put("cellValue", cellValue);
                            invalidAreaCodeMap.put("remarks", "No Such Area Code Found");
                            invalidAreaCodeMap.put("rowNumber", (currentRow.getRowNum() + 1));
                            invalidAreaCodeMap.put("domain", BkashMoneyMaster.class.newInstance());

                            invalidAreaCodeMapList.add(invalidAreaCodeMap);
//                            this.saveInvalidAreaCodeTmp(cellValue, (currentRow.getRowNum() + 1), BkashMoneyMaster.class.newInstance());

                            continue;
                        }

                        bkashMoneyDetailsModel.setProjectSetup(projectSetup);
                        bkashMoneyDetailsModel.setAreaCurrentAccCode(areaCode);

                        String narration = "Received from " + areaCode.getName() + " [" + areaCode.getAreaCurrentAcCode() + "] through bKash Ltd. agt. " + particulars;
                        bkashMoneyDetailsModel.setNarration(narration);

                    } else {
                        invalidAreaCodeList.add(cellValue);

                        invalidAreaCodeMap.put("cellValue", cellValue);
                        invalidAreaCodeMap.put("remarks", "No Such Area Code Found");
                        invalidAreaCodeMap.put("rowNumber", (currentRow.getRowNum() + 1));
                        invalidAreaCodeMap.put("domain", BkashMoneyMaster.class.newInstance());

                        invalidAreaCodeMapList.add(invalidAreaCodeMap);
//                        this.saveInvalidAreaCodeTmp(cellValue, (currentRow.getRowNum() + 1), BkashMoneyMaster.class.newInstance());

                        continue;
                    }
                } else {
                    throw new RuntimeException("Invalid Project RefCode at row no: [" + (currentRow.getRowNum() + 1) + "]");
                }*/

                /*if (currentRow.getCell(1) != null) {
                    currentCell = currentRow.getCell(1);
                    currentCell.setCellType(CellType.NUMERIC);

                    bkashMoneyDetailsModel.setAmount(currentCell.getNumericCellValue());

                    commissionAmount = (bkashMoneyDetailsModel.getAmount() * commission) / 100;

                    bkashMoneyDetailsModel.setCommission((double) Math.round(commissionAmount));
                    bkashMoneyDetailsModel.setNetAmount((double) Math.round(bkashMoneyDetailsModel.getAmount()) - Math.round(commissionAmount));

                } else {
                    throw new RuntimeException("Invalid Amount at row no: [" + (currentRow.getRowNum() + 1) + "]");
                }

                bkashMoneyDetailsModel.setSlNumber(++slNumber);
                bkashMoneyDetailsModels.add(bkashMoneyDetailsModel);*/
            }

            workbook.close();

//            if (invalidAreaCodeMapList.size() > 0) {
//                this.saveInvalidAreaCodeTmp(invalidAreaCodeMapList);
//            }
//
//            if (invalidAreaCodeList.size() > 0) {
//                excelService.insertQueryForInvalidAreaCodeTmp(invalidAreaCodeList);
//            }

            return bkashMoneyDetailsModels;

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
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

   }
