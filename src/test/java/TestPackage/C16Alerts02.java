package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C16Alerts02 {
    WebDriver driver;
    String url = "http://demo.automationtesting.in/Alerts.html";

    @Test
    void alertTest() {
        //Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get(url);
        //Click "Alert with OK" and click 'click the button to display an alert box:’
        clickAlertOption(1);
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //Accept Alert(I am an alert box!) and print alert on console.
        String fisrtAlertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        clickAlertOption(2);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //Cancel Alert  (Press a Button !)
        String secondAlertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        clickAlertOption(3);
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //And then sendKeys «Bootcamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("Bootcamp");
        driver.switchTo().alert().accept();

        //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
        WebElement text = driver.findElement(By.id("demo1"));
        System.out.println("text = " + text.getText());
        Assertions.assertEquals("Hello Bootcamp How are you today",text.getText());
    }

    private void clickAlertOption(int i) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='analystic'])["+i+"]"))).click();
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
