package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
In Selenium, waits are used to handle the synchronization between the script
and the web application. Since web elements may take time to load, appear, or
become clickable, using waits ensures that the script interacts with elements
only when they are ready. Without waits, tests may fail due to timing issues
like ElementNotFoundException.

Selenium provides three types of waits:
    1)  Implicit Wait (applies a global timeout for element searches),
    2)  Explicit Wait (waits for specific conditions like visibility or clickability)
    3)  Fluent Wait (a more flexible wait with polling frequency and exception handling).

    Using waits properly makes tests more stable and reliable.
 */
public class C14ExplicitWaitAndFluentWait {
    WebDriver driver;
    String url = "https://webdriveruniversity.com/Popup-Alerts/index.html";
    By clickMeLinkByXpath = By.xpath("//a[.='CLICK ME!']");
    By clickMeButton = By.id("button1");
    By wellDoneTextByTagName = By.tagName("h4");
    @Test
    void expliciteWaitTest()  {
/*
    Specifies the condition and the time that WebDriver should wait.
    In practice, WebDriverWait and Explicit Wait are synonymous,
    since their definitions and usage perfectly match.

    // How to use Explicit Wait
    // 1- Create a WebDriverWait object
    // 2- Pass the desired condition to the 'until' method of the wait object
*/

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        driver.get(url);
        //    Click on Ajax Loader
        driver.findElement(clickMeLinkByXpath).click();
        //    Click on 'Click Me'
        driver.findElement(clickMeButton).click();
        //    Assert text "Well Done For Waiting....!!!"

        // First Way : Using "ExpectedConditions"
        //wait.until(ExpectedConditions.visibilityOfElementLocated(wellDoneTextByTagName));
        //Assertions.assertTrue(driver.findElement(wellDoneTextByTagName).getText().contains("Well Done For Waiting"));

        // Second Way: Write your own wait strategy
        wait.until(t-> t.findElement(wellDoneTextByTagName).isDisplayed());
        Assertions.assertTrue(driver.findElement(wellDoneTextByTagName).getText().contains("Well Done For Waiting"));



    }
    @Test
    void fluemtWaitTest() throws InterruptedException {
/*
   Fluent Wait is a type of Explicit Wait that allows you to define:
   - The maximum time to wait for a condition
   - The polling period (how often to check the condition)
   - Ignored exceptions while waiting (e.g., NoSuchElementException)
   It provides more flexibility than Implicit and Explicit Wait.
*/

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(13))
                        .pollingEvery(Duration.ofMillis(500))
                                .ignoring(NotFoundException.class);

        //    Go to https://webdriveruniversity.com/Popup-Alerts/index.html
        driver.get(url);
        //    Click on Ajax Loader
        driver.findElement(clickMeLinkByXpath).click();
        //    Click on 'Click Me'
        driver.findElement(clickMeButton).click();
        //    Assert text "Well Done For Waiting....!!!"

        // First Way : Using "ExpectedConditions"
        wait.until(ExpectedConditions.visibilityOfElementLocated(wellDoneTextByTagName));
        Assertions.assertTrue(driver.findElement(wellDoneTextByTagName).getText().contains("Well Done For Waiting"));

        // Second Way: Write your own wait strategy
        //wait.until(t-> t.findElement(wellDoneTextByTagName).isDisplayed());
        //Assertions.assertTrue(driver.findElement(wellDoneTextByTagName).getText().contains("Well Done For Waiting"));

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
