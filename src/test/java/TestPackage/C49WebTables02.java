package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;


public class C49WebTables02 extends TestBase {
    /*
        Go to URL: https://the-internet.herokuapp.com/tables
        Print the entire table
        Print All Rows
        Print Last row data only
        Print column 5 data in the table body
        Write a method that accepts 2 parameters
        parameter 1 = row number
        parameter 2 = column number
    */
    @Test
    public void webTableTest() {
    //    Go to URL: https://the-internet.herokuapp.com/tables
            driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rowsList = driver.findElements(By.xpath("//table[1]//tr"));
        int numOfRows = rowsList.size();
        int numOfColumns = driver.findElements(By.xpath("//table[1]//tr[1]//th")).size();

    //    Print the entire table

        for (int i =1;i<numOfRows;i++ ){

            for (int j=1; j<=numOfColumns; j++){
                String data = driver.findElement(By.xpath("//table[1]//tr["+i+"]//td["+j+"]")).getText();
                System.out.print(data +" || ");
            }
            System.out.println();
            System.out.println(i + " line data is printed ******************");
        }
    //    Print All Rows
        rowsList.forEach(t-> System.out.println(t.getText()));

    //    Print Last row data only
        System.out.println("rowsList.getLast().getText() = " + rowsList.getLast().getText());

        //    Print column 5 data in the table body
        List<WebElement> webSitesList = driver.findElements(By.xpath("//table[1]//td[5]"));
        webSitesList.forEach(t -> System.out.print(t.getText() + " || "));

    //    Write a method that accepts 2 parameters
    //    parameter 1 = row number
    //    parameter 2 = column number
        C48WebTables01 obj = new C48WebTables01();

        System.out.println("obj.getDataFromTable(2,4) = " + obj.getDataFromTable(2, 4));

    }

}
