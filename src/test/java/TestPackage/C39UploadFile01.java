package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Path;

public class C39UploadFile01 extends TestBase {
    @Test
    void name() {
        //Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        //Find the path of the file that you want to upload.
        Path filePath = Path.of(System.getProperty("user.home"),"Downloads","Screenshot (1).png");
        String fileStrPAth = filePath.toString();

        //Click on Upload button.
        driver.findElement(By.id("file-upload")).sendKeys(fileStrPAth);
        driver.findElement(By.id("file-submit")).click();

        //Verify the upload message.
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("File Uploaded!"));
    }
}
