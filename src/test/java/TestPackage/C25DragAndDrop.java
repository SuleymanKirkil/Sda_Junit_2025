package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C25DragAndDrop extends TestBase {
    /*
     Go to URL: http://demo.guru99.com/test/drag_drop.html
    Drag and drop the BANK button to the Account section in DEBIT SIDE
    Drag and drop the SALES button to the Account section in CREDIT SIDE
    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
    Verify the visibility of Perfect text.
     */
    String url = "http://demo.guru99.com/test/drag_drop.html";
    By bankButtonBy = By.id("credit2");
    By salesButtonBy = By.id("credit1");
    By fiveThousandsButton1By = By.xpath("//li[@id='fourth'][1]");
    By fiveThousandsButton2By = By.xpath("//li[@id='fourth'][2]");
    By debitAccountFieldBy = By.id("bank");
    By creditAccountFieldBy = By.id("loan");
    By debitAmountFieldBy = By.id("amt7");
    By creditAmountFieldBy = By.id("amt8");
    By successBy = By.xpath("//a[@class='button button-green'][.='Perfect!']");

    @Test
    void test() {
        driver.get(url);

        // sources
        WebElement bank = driver.findElement(bankButtonBy);
        WebElement sales = driver.findElement(salesButtonBy);
        WebElement fiveThousand1 = driver.findElement(fiveThousandsButton1By);
        WebElement fiveThousand2 = driver.findElement(fiveThousandsButton2By);

        //targerts
        WebElement debitAccount = driver.findElement(debitAccountFieldBy);
        WebElement creditAccount = driver.findElement(creditAccountFieldBy);
        WebElement debitAmount = driver.findElement(debitAmountFieldBy);
        WebElement creditAmount = driver.findElement(creditAmountFieldBy);



        // Go to URL: http://demo.guru99.com/test/drag_drop.html
        Actions action = new Actions(driver);

        action
                .dragAndDrop(bank,debitAccount)//Drag and drop the BANK button to the Account section in DEBIT SIDE
                .pause(1000)
                .dragAndDrop(sales,creditAccount)
                .pause(1000)
                .dragAndDrop(fiveThousand1,debitAmount)
                .pause(1000)
                .dragAndDrop(fiveThousand2,creditAmount)
                .perform();

        //Verify the visibility of Perfect text.
        Assertions.assertTrue(driver.findElement(successBy).isDisplayed());
    }
}
