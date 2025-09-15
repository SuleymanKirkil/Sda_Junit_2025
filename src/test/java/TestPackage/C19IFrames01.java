package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C19IFrames01 extends TestBase {
    @Test
    void name() {
        String url="https://the-internet.herokuapp.com/iframe";
        String expectesText = "Editor";

        By headerByTagName = By.tagName("h3");
        By closeButtonByXpath = By.xpath("//div[@aria-label='Close']");
        By textBoxByXpath = By.xpath("//p[.='Your content goes here.']");
        By elementalTextByXpath = By.xpath("//a[.='Elemental Selenium']");

        //Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get(url);
        driver.findElement(closeButtonByXpath).click();

        //Verify the Bolded text contains “Editor”
        Assertions.assertTrue(driver.findElement(headerByTagName).getText().contains(expectesText));

        //Locate the text box
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        //driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));

        WebElement element = driver.findElement(textBoxByXpath);

        //Print the text in the text box
        System.out.println("element.getText() = " + element.getText());

        //Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();
        WebElement textElement = driver.findElement(elementalTextByXpath);
        Assertions.assertTrue(textElement.isDisplayed());

    }
}
