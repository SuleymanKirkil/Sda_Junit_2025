// STEP 2: ExtentReports Integrated with TestBaseExtentReport
// These classes can take screenshots along with WebDriver

package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseExtentReport {
    
    // WebDriver and ExtentReports objects
    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentSparkReporter sparkReporter;
    protected ExtentTest test;
    
    // Folder for screenshots
    protected static final String SCREENSHOT_PATH = "test-output/screenshots/";
    
    @BeforeAll
    static void setupClass() {
        // Create screenshot folder
        new File(SCREENSHOT_PATH).mkdirs();
        
        // ExtentReports setup
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss"));
        sparkReporter = new ExtentSparkReporter("test-output/TestReport_" + timestamp + ".html");
        
        // Report configuration
        sparkReporter.config().setReportName("Selenium Test Report");
        sparkReporter.config().setDocumentTitle("Web Test Results");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        // System information
        extent.setSystemInfo("Tester", "Automation Student");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Test Date", timestamp);
    }
    
    @BeforeEach
    void setUp() {
        // New driver for each test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @AfterEach
    void tearDown() {
        // Close driver
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterAll
    static void tearDownClass() {
        // Save report
        if (extent != null) {
            extent.flush();
        }
        System.out.println(" Test report created!");
    }
    
    /**
     * Takes screenshot and returns file path
     */
    protected String takeScreenshot(String testName) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));
            String fileName = testName + "_" + timestamp + ".png";
            String fullPath = SCREENSHOT_PATH + fileName;
            
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(fullPath);
            
            FileUtils.copyFile(sourceFile, destFile);

            return "screenshots/" + fileName;

        } catch (IOException e) {
            System.err.println("Could not take screenshot: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Adds log with screenshot for failed test cases
     */
    protected void logFailureWithScreenshot(String message) {
        String screenshotPath = takeScreenshot("failed_test");
        if (screenshotPath != null) {
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.fail(message);
        }
    }
    
    /**
     * Adds log with screenshot for successful test cases
     */
    protected void logPassWithScreenshot(String message) {
        String screenshotPath = takeScreenshot("passed_test");
        if (screenshotPath != null) {
            test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.pass(message);
        }
    }
}

// =============================================================================
