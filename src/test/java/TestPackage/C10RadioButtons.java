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

public class C10RadioButtons {
    WebDriver driver;
    String url ="https://www.facebook.com/";

    @Test
    void radioButtonTest() {
      // Go to URL:  https://www.facebook.com/
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div[1]/div[2]/div/div[1]/div/span/span")).click();
      // Click on Create an Account button.
        driver.findElement(By.xpath("//a[.='Create new account']")).click();
      // Then click on the radio buttons.

       WebElement femaleButton = driver.findElement(By.xpath("//span[.='Female']"));

       femaleButton.click();
        Assertions.assertTrue(femaleButton.isSelected());


    }

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver(new ChromeOptions().addArguments("--disable-cookies"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
