package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C37DownloadFile extends TestBase {
    /*
Go to URL: https://the-internet.herokuapp.com/download
    Download selenium-snapshot.png
    Verify if the file downloaded successfully.
*/

    @Test
    public void FileDownLoadTest() throws InterruptedException, IOException {
        String fileName = "random_data.txt";

        By seleniumSnapLinkText = By.linkText(fileName);
        //Go to URL: https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        //Download selenium-snapshot.png
        driver.findElement(seleniumSnapLinkText).click();
        Thread.sleep(2000);

        //Verify if the file downloaded successfully
        String sep = System.getProperty("file.separator");
        String filePath = sep+System.getProperty("user.home")+sep+"Downloads"+sep+fileName;

        // Path path2 = Paths.get(System.getProperty("user.home"),"Downloads","selenium-snapshot.png");
        Path path = Path.of(System.getProperty("user.home"),"Downloads",fileName);
        System.out.println("path.toString() = " + path.toString());
        Assertions.assertTrue(Files.exists(path));

        Files.deleteIfExists(Path.of(filePath));

}
}
