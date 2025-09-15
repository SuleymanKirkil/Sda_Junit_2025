package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C06_RelativeLocator {


    @Test
    void relativeLocatorTest() {

        driver.get("https://clarusway.com/");
        WebElement cyberSecurity = driver.findElement(By.xpath("//a/span/span[.='Cybersecurity']"));
        WebElement aIPoweredFullStack = driver.findElement(RelativeLocator.with(By.tagName("span")).toLeftOf(cyberSecurity));
        System.out.println("aIPoweredFullStack.getText() = " + aIPoweredFullStack.getText());
        aIPoweredFullStack.click();

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
