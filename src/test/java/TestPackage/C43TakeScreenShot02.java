package TestPackage;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C43TakeScreenShot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws InterruptedException {
        driver.get("https://www.linkedIn.com");
        Thread.sleep(3000);
        takeScreenShot(driver);

        WebElement element = driver.findElement(By.xpath("//icon[@data-test-id]"));
        takeScreenshotOfElement(driver,element);

    }



}
