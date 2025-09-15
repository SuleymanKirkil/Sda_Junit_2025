package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C27HoverOver extends TestBase {
/*
    Go to URL: https://www.browserstack.com/
    Hover over on “Products” link.
    Click on "Automate".
    Verify the page URL contains “automate”.
*/
    By productsLinkId = By.id("products-dd-toggle");
    By automateLinkXpath = By.xpath("//div[@id='products-dd-tabpanel-1-inner-1']//span[.='Automate']");
    String url = "https://www.browserstack.com/";
    @Test

    public void hoverOverTest() throws InterruptedException {

//Go to URL: https://www.browserstack.com/
    driver.get(url);
//Hover over on “Products” link.
        Actions action = new Actions(driver);

        WebElement productsMenu = driver.findElement(productsLinkId);

        action
                .moveToElement(productsMenu)
                .pause(2000)
                .click(driver.findElement(automateLinkXpath))
                .pause(2000)
                .perform();

//Verify the page URL contains “automate”.
        Assertions.assertTrue(driver.getCurrentUrl().toLowerCase().contains("automate"));
    }
}
