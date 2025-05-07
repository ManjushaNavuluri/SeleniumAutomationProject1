package project;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        FileInputStream excelFile = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(excelFile);
        sheet = workbook.getSheet(sheetName);
    }
    public static String getCellData(int rowNumber, int columnNumber) {
        if(sheet == null) {
            return null;
        }
        Row row = sheet.getRow(rowNumber);
        if(row == null) {
            return null;
        }
        Cell cell = row.getCell(columnNumber);
        if(cell == null) {
            return null;
        }
        
        switch(cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return Double.toString(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
}