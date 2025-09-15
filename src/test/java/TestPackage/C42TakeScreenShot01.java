package TestPackage;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptUtils;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C42TakeScreenShot01 extends TestBase {
/*
    Go to https://opensource-demo.orangehrmlive.com/
    Take full page screenshot
    Take a specific element's screenshot
*/

    @Test
    public void screenShotTest() throws IOException, InterruptedException {
 //       Go to Clarusway
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.className("orangehrm-login-branding"));
        JavaScriptUtils.highlightElement(driver,element);

 //       Take full page screenshot
        TakesScreenshot ss =  (TakesScreenshot)driver;
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        Path path2 = Path.of(System.getProperty("user.dir"),"screenshot","lastScrenshot.png");
        Path path1 = Path.of(System.getProperty("user.dir"),"target","test-output","screenshot","lastScrenshot"+timeStamp+".png");
        Path path = Path.of(System.getProperty("user.home"),"Desktop","test-output","screenshot","Screnshot"+timeStamp+".png");

        FileUtils.copyFile(screenShot,path.toFile());
 //       Take a specific element's screenshot
        File elementScreenShot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementScreenShot,path1.toFile());
 }
}
