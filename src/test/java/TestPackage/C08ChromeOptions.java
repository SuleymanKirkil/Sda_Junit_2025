package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C08ChromeOptions {
    /*
        start-maximized: Opens Chrome in maximized mode.

        incognito: Opens Chrome in incognito mode.

        --headless: Runs Chrome in headless mode (without UI).

        disable-extensions: Disables the existing extensions in Chrome.

        disable-popup-blocking: Disables pop-up blocking in Chrome.

        disable-infobars: Prevents Chrome from displaying the message "Chrome is being controlled by automated software."

        --disable-cookies: Blocks cookies.
     */
    WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("--headless");
        options.addArguments("--disable-cookies");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    void chromeOptionsTest() {
        driver.get("http://www.bestbuy.com");
        //WebElement bestBuyLogo1 = driver.findElement(By.xpath("//div[@lang='en']//img[@class='logo']"));
        //Assertions.assertTrue(bestBuyLogo1.isDisplayed());
    }


}
