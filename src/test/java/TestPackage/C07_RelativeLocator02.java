package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C07_RelativeLocator02 {


    @Test
    void relativeLocatorTest() {
        //Go to http://www.bestbuy.com
        //Verify that the page title contains " Hello" Also, using Relative Locator.
        //LogoTest 🡪 Verify if the BestBuy logo is displayed.
        //CanadaLinkTest 🡪 Verify if the link is displayed.

        //Go to http://www.bestbuy.com
        driver.get("http://www.bestbuy.com");

        //Verify that the page title contains " Hello" Also, using Relative Locator.
        WebElement bestBuyLogo1 = driver.findElement(By.xpath("//div[@lang='en']//img[@class='logo']"));
        Assertions.assertTrue(bestBuyLogo1.isDisplayed());

        WebElement bestBuyLogo2 = driver.findElement(RelativeLocator.with(By.xpath("//img[@class='logo' and @alt ='Best Buy Logo']")).above(By.xpath("//*[.='Hello!']")));

        //LogoTest 🡪 Verify if the BestBuy logo is displayed.
        Assertions.assertTrue(bestBuyLogo2.isDisplayed());

        //CanadaLinkTest 🡪 Verify if the link is displayed.
        WebElement canadaLink = driver.findElement(By.xpath("(//div[@class='country-selection']//a[@class='canada-link'])[1]"));
        Assertions.assertTrue(canadaLink.isDisplayed());
        // try to locate Canada Link by relative locators

    }


    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
