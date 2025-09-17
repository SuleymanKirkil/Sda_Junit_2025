package TestPackage;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class C47WriteEcel03 {

    private static final Path EMPLOYEESPATH = Path.of(".", "resources", "Employees.xlsx");

    @Test
    public void addNewNameLastNameTest() throws IOException {
        addFiveEmployees();

        addNewEmployee("TestName","TestLastName");
    }

    private void addFiveEmployees() throws IOException {
            Workbook workbook;
            try (FileInputStream fis = new FileInputStream(EMPLOYEESPATH.toString())){
                workbook = WorkbookFactory.create(fis);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i<5; i++){
                sheet.createRow(sheet.getLastRowNum()+1).createCell(0).setCellValue(Faker.instance().name().firstName());
                sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(Faker.instance().name().lastName());
            }

            try (FileOutputStream fos = new FileOutputStream(EMPLOYEESPATH.toString())) {
                workbook.write(fos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            workbook.close();
    }

    private void addNewEmployee(String name, String lastname) throws IOException {
        Workbook workbook;
        try (FileInputStream fis = new FileInputStream(EMPLOYEESPATH.toString())){
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);

            sheet.createRow(sheet.getLastRowNum()+1).createCell(0).setCellValue(name);
            sheet.getRow(sheet.getLastRowNum()).createCell(1).setCellValue(lastname);

        try (FileOutputStream fos = new FileOutputStream(EMPLOYEESPATH.toString())) {
            workbook.write(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        workbook.close();
    }
}


