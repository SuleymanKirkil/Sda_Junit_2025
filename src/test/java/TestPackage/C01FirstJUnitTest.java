package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C01FirstJUnitTest {

    @Test
    void myFisrtTest(){
        System.out.println("My First Test");

        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assertions.assertEquals("Google",actualTitle,"Title is different from 'Google'");

        driver.findElement(By.id("name")).sendKeys(Keys.chord(Keys.COMMAND , "a"));



    }
}
