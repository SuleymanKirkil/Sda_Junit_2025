package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C48WebTables01 extends TestBase {
    /*
    <table> is an HTML tag used to define a web table.
    <th> is used to define table headers, while <tr> and <td> tags are used
    to define rows and columns respectively for web tables.

    table//tbody//tr ➡ Returns all rows within tbody.
    table//tbody//tr[1] ➡ Returns the first row in tbody.
    table//tbody//tr[1]//td ➡ Returns all table cells in the first row.
    table//tbody//tr[1]//td[4] ➡ Returns the 4th cell in the first row of tbody.
    table//tbody//tr[4]//td[5] ➡ Row 4, Column 5
    table//tbody//tr[10]//td[2] ➡ Column 2 in Row 10
    table//tbody//tr//td[5] ➡ Returns all rows in the 5th column.

    // Go to URL: http://demo.guru99.com/test/web-table-element.php
    // To find third row of table
    // To get 3rd row's 3rd column data
    // Get all the values of a Dynamic Table
    */

    @Test
    public void webTableTest() {
        // Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");

        // To find third row of table
        By r3By = By.xpath("//tbody//tr[3]");
        WebElement r3 = driver.findElement(r3By);
        System.out.println("r3.getText() = " + r3.getText());

        // To get 3rd row's 3rd column data
            // First Way: get from r3 element
        WebElement r3d3 = r3.findElement(By.xpath(".//td[3]"));
        System.out.println("r3d3.getText() = " + r3d3.getText());

            // Second Way: Through locator:
        WebElement r3d3New = driver.findElement(By.xpath("//tbody//tr[3]//td[3]"));
        System.out.println("r3d3New.getText() = " + r3d3New.getText());

        // Get all the values of a Dynamic Table
        List<WebElement> rowsList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("************* All Data On The Table ******************  ");
        for (WebElement row: rowsList){
            System.out.println("row.getText() = " + row.getText());
        }
        int lineCount =1;

        for (WebElement row: rowsList){
            List<WebElement> tdList =row.findElements(By.xpath(".//td"));
            System.out.println("Line " + lineCount+ " )");
            for (WebElement data:tdList){
                System.out.print(data.getText() + " || ");
            }
            System.out.println();
            lineCount++;
        }

        // Helper methods similar to the one below can be created in utils class
        String r2d3 = getDataFromTable(2,3);
        System.out.println("r2d3 = " + r2d3);

    }

    public String getDataFromTable(int trow, int tdata) {
        return driver.findElement(By.xpath("//tbody//tr["+trow+"]//td["+tdata+"]")).getText();
    }

}