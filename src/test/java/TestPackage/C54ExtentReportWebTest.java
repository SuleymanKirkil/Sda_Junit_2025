package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseExtentReport;

public class C54ExtentReportWebTest extends TestBaseExtentReport {

    @Test
    void positiveLoginTest() {
        test =extent.createTest("Positive Login Test","User Logs in the application with correct credentials");
        test.info("Test started");

        try {
            String name = "Admin";
            String password = "admin123";
            //Go to URL: https://opensource-demo.orangehrmlive.com/
            driver.get("https://opensource-demo.orangehrmlive.com/");
            test.info("User navigates to url");

            //Login page valid credentials.
            test.info("User enter correct credentials");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            String url = driver.getCurrentUrl();

            if (url.contains("dashboard")){
                logPassWithScreenshot("The user is signed in succesfully");
            } else {
                logFailureWithScreenshot("The user is NOT signed in to the application");
            }

        } catch (Exception e){
            logFailureWithScreenshot("Error occured during execution");
        }
    }

    @Test
    void failingLoginTest() {
        test =extent.createTest("Failing Login Test","We practice Error message on the report");
        test.info("Test started");

        try {
            String name = "Admi";
            String password = "admin123";
            //Go to URL: https://opensource-demo.orangehrmlive.com/
            driver.get("https://opensource-demo.orangehrmlive.com/");
            test.info("User navigates to url");

            //Login page valid credentials.
            test.info("User enter correct credentials");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            String url = driver.getCurrentUrl();

            if (url.contains("dashboard")){
                logPassWithScreenshot("The user is signed in succesfully");
            } else {
                logFailureWithScreenshot("The user is NOT signed in to the application");
            }

        } catch (Exception e){
            logFailureWithScreenshot("Error occured during execution");
        }
    }
    @Test
    void failingLoginTest2() {
        test =extent.createTest("Failing Login Test","We practice Error message on the report");
        test.info("Test started");

        try {
            String name = "Admin";
            String password = "admin123";
            //Go to URL: https://opensource-demo.orangehrmlive.com/
            driver.get("https://opensource-demo.orangehrmlive.com/");
            test.info("User navigates to url");

            //Login page valid credentials.
            test.info("User enter correct credentials");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submi']")).click();
            Thread.sleep(3000);
            String url = driver.getCurrentUrl();

            if (url.contains("dashboard")){
                logPassWithScreenshot("The user is signed in succesfully");
            } else {
                logFailureWithScreenshot("The user is NOT signed in to the application");
            }

        } catch (Exception e){
            logFailureWithScreenshot("Error occured during execution");
            e.printStackTrace();
        }
    }
    @Test
    void negativeTestLoginTest() {
        test =extent.createTest("Negative Login Test","User should not Logged in to the application with invalid credentials");
        test.info("Test started");

        try {
            String name = "Admi";
            String password = "admin123";
            //Go to URL: https://opensource-demo.orangehrmlive.com/
            driver.get("https://opensource-demo.orangehrmlive.com/");
            test.info("User navigates to url");

            //Login page valid credentials.
            test.info("User enter correct credentials");
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys(name);
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            String url = driver.getCurrentUrl();

            if (url.contains("login")){
                logPassWithScreenshot("The user is NOT signed in with invalid credential");
            } else {
                logFailureWithScreenshot("The user is signed in with invalid credentials");
            }

        } catch (Exception e){
            logFailureWithScreenshot("Error occured during execution");
        }
    }
}
