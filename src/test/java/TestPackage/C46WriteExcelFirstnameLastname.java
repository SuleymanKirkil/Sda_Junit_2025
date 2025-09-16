package TestPackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.http.HttpClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class C46WriteExcelFirstnameLastname {

    //Create Firstname and Lastname Columns and write names in a new sheet

    @Test
    public void excelTest() throws IOException {

        // Create new workbook
        Workbook workbook = WorkbookFactory.create(true); // create(true) -> .xlsx   ; create(false) -> .xls extensions

        //Create a new sheet
        Sheet sheet = workbook.createSheet("FirstNameLastName");

        //Create Firstname and Lastname Columns
        sheet.createRow(0).createCell(0).setCellValue("FIRSTNAME");
        sheet.getRow(0).createCell(1).setCellValue("LASTNAME");

        //Fill some rows

        sheet.createRow(1).createCell(0).setCellValue("John");
        sheet.getRow(1).createCell(1).setCellValue("Doe");

        String[][] employees = {
                {"Marry", "Joe"},
                {"Tom", "Hanks"},
                {"Tom", "Sawyer"}
        };

        for (String[] employee : employees) {
            sheet.createRow(sheet.getLastRowNum() + 1).createCell(0).setCellValue(employee[0]);
            sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(employee[1]);
        }

        addNewEmployee(sheet,"Suleyman","Clarusway");

        FileOutputStream fos = new FileOutputStream(Path.of(".","resources","Employees.xlsx").toString());
        workbook.write(fos);
    }


    private void addNewEmployee(Sheet sheet,String name, String lastname) {
        sheet.createRow(sheet.getLastRowNum() + 1).createCell(0).setCellValue(name);
        sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(lastname);
    }
}

