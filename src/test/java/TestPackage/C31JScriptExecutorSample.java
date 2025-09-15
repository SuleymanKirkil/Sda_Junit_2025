package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptUtils;
import utilities.TestBase;

public class C31JScriptExecutorSample extends TestBase {
    @Test
    public void name() throws InterruptedException {

        //       Go to URL: https://demoqa.com/buttons
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        WebElement rigthClickButton = driver.findElement(By.id("rightClickBtn"));
        WebElement clickMEButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Click the clickME button on the page.
        JavaScriptUtils.clickElement(driver,clickMEButton);

        // Verify the texts that appear after the buttons are operated.
        Assertions.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());

    }
}
