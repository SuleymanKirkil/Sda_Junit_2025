package TestPackage;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class C44ReadExcellFile {
    /*
        Add the excel file on the resources folder.
        Open the file.
        Open the workbook using file input stream.
        Open the first worksheet.
        Go to first row.
        Go to first cell on that first row and print.
        Go to second cell on that first row and print.
        Go to 2nd row first cell and assert if the data equal to the USA.
        Go to 3rd row and print 2nd cell
        Find the number of used row.
        Print country, capital value pairs as map object.
        Verify that you have Canada on the list
    */
    @Test
    public void readExcelTest() throws IOException {
 //       Add the excel file on the resources folder.
 //       Open the file.
        FileInputStream fis =new FileInputStream(Path.of(".","resources","Countries.xlsx").toString());
 //       Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

 //       Open the first worksheet.
        //Sheet sheet = workbook.getSheet("Sheet1");
        Sheet sheet = workbook.getSheetAt(0);

 //       Go to first row.
        Row firstRow =sheet.getRow(0);

 //       Go to first cell on that first row and print.
        Cell r1c1 = firstRow.getCell(0);
        System.out.println("r1c1 = " + r1c1);

//       Go to second cell on that first row and print.
        System.out.println("firstRow.getCell(1) = " + firstRow.getCell(1));

//       Go to 2nd row first cell and assert if the data equal to the USA.
        Cell r2c1= sheet.getRow(1).getCell(0);
        String expectesStr = "USA";
        String actualStr = r2c1.toString();
        Assertions.assertEquals(expectesStr,actualStr);

 //       Go to 3rd row and print 2nd cell
        String r3c2Str = getCellData(sheet,3,2);
        System.out.println("r3c2Str = " + r3c2Str);

//       Find the number of used row.
        int indexOfLastRow = sheet.getLastRowNum(); // Return the index of last row //10
        int numOfUsedRows = sheet.getPhysicalNumberOfRows(); // Returns nımber of used rows //
        System.out.println("indexOfLastRow = " + indexOfLastRow);
        System.out.println("numOfUsedRows = " + numOfUsedRows);

//       Print country, capital value pairs as map object.

        Map<String,String> countryMap = new HashMap<>();
        for (int i= 1;i<= sheet.getLastRowNum();i++){
            String country = sheet.getRow(i).getCell(0).toString();
            String capital = sheet.getRow(i).getCell(1).toString();
            countryMap.put(country,capital);
        }

        System.out.println("countryMap = " + countryMap);

        // Assert Canada is one of the caountries
        Assertions.assertTrue(countryMap.containsKey("Canada"));

        Assertions.assertTrue(countryMap.containsValue("Riyadh"));

        workbook.close();
    }

    private String getCellData(Sheet sheet, int row, int cell) {
        return sheet.getRow(row-1).getCell(cell-1).toString();
    }

    @Test
    void test02() {
        //       Add the excel file on the resources folder.
        //       Open the file.

        Workbook workbook;
        try (FileInputStream fis = new FileInputStream(Path.of(".","resources","Countries.xlsx").toString());){
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //       Open the first worksheet.
        //Sheet sheet = workbook.getSheet("Sheet1");
        Sheet sheet = workbook.getSheetAt(0);

        //       Go to first row.
        Row firstRow =sheet.getRow(0);

        //       Go to first cell on that first row and print.
        Cell r1c1 = firstRow.getCell(0);
        System.out.println("r1c1 = " + r1c1);

//       Go to second cell on that first row and print.
        System.out.println("firstRow.getCell(1) = " + firstRow.getCell(1));

//       Go to 2nd row first cell and assert if the data equal to the USA.
        Cell r2c1= sheet.getRow(1).getCell(0);
        String expectesStr = "USA";
        String actualStr = r2c1.toString();
        Assertions.assertEquals(expectesStr,actualStr);

        //       Go to 3rd row and print 2nd cell
        String r3c2Str = getCellData(sheet,3,2);
        System.out.println("r3c2Str = " + r3c2Str);

//       Find the number of used row.
        int indexOfLastRow = sheet.getLastRowNum(); // Return the index of last row //10
        int numOfUsedRows = sheet.getPhysicalNumberOfRows(); // Returns nımber of used rows //
        System.out.println("indexOfLastRow = " + indexOfLastRow);
        System.out.println("numOfUsedRows = " + numOfUsedRows);

//       Print country, capital value pairs as map object.

        Map<String,String> countryMap = new HashMap<>();
        for (int i= 1;i<= sheet.getLastRowNum();i++){
            String country = sheet.getRow(i).getCell(0).toString();
            String capital = sheet.getRow(i).getCell(1).toString();
            countryMap.put(country,capital);
        }

        System.out.println("countryMap = " + countryMap);

        // Assert Canada is one of the caountries
        Assertions.assertTrue(countryMap.containsKey("Canada"));

        Assertions.assertTrue(countryMap.containsValue("Riyadh"));

        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
