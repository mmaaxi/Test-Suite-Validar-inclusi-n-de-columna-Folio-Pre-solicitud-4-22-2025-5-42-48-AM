package pages;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class tc_010Page {
    WebDriver driver;
    Workbook workbook;
    Sheet sheet;

    public tc_010Page(WebDriver driver) {
        this.driver = driver;
    }

    public void exportReport() {
        // Code to automate exporting of report
    }

    public void openExcelAndFindRamo() {
        try {
            FileInputStream file = new FileInputStream(new File("path/to/exported/report.xlsx"));
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRamoFieldIdentified() {
        return (sheet.getRow(0).getCell(0).getStringCellValue().equals("Ramo"));
    }

    public void verifyColumnPreSolicitudIsRightOfRamo() {
        int ramoIndex = sheet.getRow(0).getPhysicalNumberOfCells();

        boolean isPreSolicitudPresent = false;
        for (int i = 1; i < ramoIndex; i++) {
            if (sheet.getRow(0).getCell(i).getStringCellValue().equals("Folio Pre solicitud")) {
                isPreSolicitudPresent = true;
                break;
            }
        }
        assert isPreSolicitudPresent;
    }

    public boolean isPreSolicitudColumnCorrect() {
        int columnIndex = sheet.getRow(0).getPhysicalNumberOfCells() - 1;
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(columnIndex) != null && !sheet.getRow(i).getCell(columnIndex).getStringCellValue().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}