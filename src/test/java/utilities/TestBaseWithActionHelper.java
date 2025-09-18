package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
TestBase Class:
We create this class to avoid repeating the same setup and teardown code
in every test class. It uses Java’s OOP (Object-Oriented Programming) concept
of inheritance.

Key points:

1. Reusability:
   - Any class that extends TestBase automatically gets access to the driver,
     setup(), and teardown() methods.
   - Child classes don’t need to write these methods again.

2. Access Modifier:
   - TestBase is usually placed in a separate package.
   - To allow child classes to use the driver, it must be declared
     as public or protected.
   - We choose "protected" since only child classes need it, not external classes.

3. Abstract Class:
   - We don’t want anyone to create objects of TestBase directly.
   - To prevent this, we declare TestBase as abstract.
   - Abstract classes can’t be instantiated; they can only be inherited.

4. Usage:
   - We will extend TestBase in our test classes.
   - The driver variable and common methods are inherited,
     which keeps our code shorter, cleaner, and easier to maintain.
*/

public abstract class TestBaseWithActionHelper {
    protected  WebDriver driver;
    protected Logger logger;
    protected ActionHelper actionHelper;
    @BeforeEach
    void setUp() {
        logger = LogManager.getLogger(TestBaseWithActionHelper.class);
        driver= new ChromeDriver();
        logger.info("Chrome browser is initialized ...");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actionHelper= new ActionHelper(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("Chrome brpwser is closed...");
    }

    protected void takeScreenShot(WebDriver driver) {
        TakesScreenshot ss =(TakesScreenshot)driver;
        File screenFile = ss.getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String screenShotName = "Screenshot"+timeStamp+ ".png";
        Path screenShotPath = Path.of(System.getProperty("user.dir"),"target","test-output","screenshots",screenShotName);

        try {
            FileUtils.copyFile(screenFile,screenShotPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    protected void takeScreenshotOfElement(WebDriver driver, WebElement element) {
        File screenShotFile = element.getScreenshotAs(OutputType.FILE);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd:HH-mm-ss"));
        String screenShotName = "ElementScreenshot"+timeStamp+ ".png";
        Path screenShotPath = Path.of(System.getProperty("user.dir"),"target","test-output","screenshots",screenShotName);

        try {
            FileUtils.copyFile(screenShotFile,screenShotPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
