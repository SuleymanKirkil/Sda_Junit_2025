package TestPackage;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseExtentReport;

import java.time.Duration;

public class C55SampleWebTests extends TestBaseExtentReport {
    
    @Test
    public void googleSearchSuccessfulTest() {
        test = extent.createTest("Google Search Test - Successful", 
                                "Will search for 'Selenium' on Google");
        
        try {
            test.info(" Navigating to Google homepage");
            driver.get("https://www.google.com");
            
            // Accept cookies button if present
            try {
                WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
                if (acceptCookies.isDisplayed()) {
                    acceptCookies.click();
                    test.info(" Cookies accepted");
                }
            } catch (Exception e) {
                test.info(" Cookie popup not found");
            }
            
            test.info(" Typing 'Selenium' in search box");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");
            searchBox.submit();
            
            // Wait for results
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
            
            // Check title
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Selenium")) {
                logPassWithScreenshot(" Search successful! Page title: " + pageTitle);
            } else {
                logFailureWithScreenshot(" 'Selenium' not found in page title: " + pageTitle);
            }
            
        } catch (Exception e) {
            logFailureWithScreenshot(" Error during test: " + e.getMessage());
            throw e;
        }
    }
    
    @Test
    public void googleSearchFailedTest() {
        test = extent.createTest("Google Search Test - Failed", 
                                "This test will intentionally fail");
        
        try {
            test.info(" Navigating to Google homepage");
            driver.get("https://www.google.com");
            
            // Accept cookies button if present
            try {
                WebElement acceptCookies = driver.findElement(By.id("L2AGLb"));
                if (acceptCookies.isDisplayed()) {
                    acceptCookies.click();
                    test.info(" Cookies accepted");
                }
            } catch (Exception e) {
                test.info(" Cookie popup not found");
            }
            
            test.info("🔍 Performing search");
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Test123xyz");
            searchBox.submit();
            
            // Intentional failure - looking for a word that won't be in title
            String pageTitle = driver.getTitle();
            if (pageTitle.contains("Java Programming Expert")) {
                logPassWithScreenshot("Test successful");
            } else {
                logFailureWithScreenshot(" Expected title not found. Actual title: " + pageTitle);
            }
            
        } catch (Exception e) {
            logFailureWithScreenshot(" Test error: " + e.getMessage());
            throw e;
        }
    }
}

/*


1. TestBaseExtentReport Pattern:
   - Common setup and cleanup operations
   - ExtentReports integration with TestBaseExtentReport
   - Automatic setup/cleanup for each test

2. Screenshot Integration:
   - takeScreenshot() method
   - Separate methods for success/failure cases
   - MediaEntityBuilder usage

3. WebDriver Integration:
   - WebDriverManager usage
   - Wait strategies
   - Exception handling

4. Report Features:
   - File naming with timestamp
   - Dark theme
   - System information
   - Rich reports with screenshots

📝 Teaching Order:
1. Show the basic example first
2. Explain TestBaseExtentReport concept
3. Explain screenshot taking logic
4. Run both test scenarios
5. Review the generated report together

⚠️ Requirements:
- Selenium WebDriver
- WebDriverManager
- ExtentReports
- Apache Commons IO
- JUnit 5
*/