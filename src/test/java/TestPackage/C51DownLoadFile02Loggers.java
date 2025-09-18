package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseWithActionHelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C51DownLoadFile02Loggers extends TestBaseWithActionHelper {
    @Test
    void name() throws InterruptedException, IOException {
        logger.info("Logger is is started");
        String name = "Admin";
        String password = "admin123";
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        logger.info("opensource web site is opened");

        //Login page valid credentials.
        actionHelper.sendKeys(By.xpath("//input[@name='username']"),name);
        actionHelper.sendKeys(By.xpath("//input[@name='password']"),password);
        actionHelper.click(By.xpath("//button[@type='submit']"));

        logger.info("Credentails are entered ...");
        //Click PIM on the left side bar
        actionHelper.click(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));

        //Click Configuration and select Data Import
        actionHelper.click(By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']"));
        actionHelper.click(By.xpath("//a[.='Data Impor']"));

        //Download sample CSV file.
        actionHelper.click(By.xpath("//*[.='Download']"));
        Thread.sleep(3000);

        Path filePath = Path.of(System.getProperty("user.home"),"Downloads","importData(1).csv");
        //Verify if the file downloaded successfully.
        Assertions.assertTrue(Files.exists(filePath));
        logger.info("Downloaded file succesfully");

        Files.deleteIfExists(filePath);
        logger.info("Downloaded file is deleted");

  }
}
