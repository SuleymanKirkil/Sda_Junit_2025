package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C17BasicAuthentication {
    //Go to URL: https://the-internet.herokuapp.com/basic_auth
    //Username: admin
    //Password: admin

    //Syntax:  driver.get("https://USERNAME:PASSWORD@URL");

    //Authenticate using the above method and test data.
    //https://admin:admin@the-internet.herokuapp.com/basic_auth
    //Verify the congratulations message.

    @Test
    void authenticationTest() throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        Assertions.assertTrue(driver.findElement(By.xpath("//h3[.='Basic Auth']")).isDisplayed());
        driver.quit();
    }
}
