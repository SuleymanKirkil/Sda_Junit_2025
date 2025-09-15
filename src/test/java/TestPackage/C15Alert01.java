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

public class C15Alert01 {
    WebDriver driver;
    String url = "http://demo.guru99.com/test/delete_customer.php";


    @Test
    void alertTest()  {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //Go to URL: http://demo.guru99.com/test/delete_customer.php
        driver.get(url);

        //Delete customer ID: 123
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //Accept firdt alert that appear.
        String firstAlertText = driver.switchTo().alert().getText();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //Accept second alert that appear.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
    @Test
    void alertTest02()  {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //Go to URL: http://demo.guru99.com/test/delete_customer.php
        driver.get(url);

        //Delete customer ID: 123
        driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //Dismiss alert that appear.
        String firstAlertText = driver.switchTo().alert().getText();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();

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
