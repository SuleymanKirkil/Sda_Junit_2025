package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C04_DynamicXPath {

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

    @Test
    void containsTest() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[contains(@id,'u_0_5_')]")).click();
        //driver.findElement(By.xpath("//*[starts-with(@id,'u_0_5_')]")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'isn’t connected')]"));
        String errorString = errorMessage.getText();
        System.out.println("errorString = " + errorString);
        Assertions.assertEquals("The email or mobile number you entered isn’t connected to an account. Find your account and log in.", errorString);
    }

    @Test
    void exactTextTest() {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        List<String> todos = new ArrayList<>(Arrays.asList("Do homework", "Study Selenium", "Go to school", "Take care of baby", "Play game", "Have dinner"));
        for (String todo : todos) {
            driver.findElement(By.xpath("//input")).sendKeys(todo, Keys.ENTER);
            String element = driver.findElement(By.xpath("//*[.=' " + todo + "']")).getText();
            //System.out.println("element = " + element);
            Assertions.assertEquals(todo, element);
        }
    }
}
