package TestPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class C53ExtendReportSimpleTest {

    private  static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ExtentTest test;

    @BeforeAll
    static void reportSetUp() {
        // Step 1: Specify where the report file will be created
        sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        // Step 2: Set report title and document name
        sparkReporter.config().setReportName("My First Extent Report");
        sparkReporter.config().setDocumentTitle("My title");
        sparkReporter.config().setTimeStampFormat("yyyy-MM-dd::HH-mm_sss");

        // Step 3: Create ExtentReports object and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Step 4: Add system information (optional)
        extent.setSystemInfo("Tester",System.getProperty("user.name"));
        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("Browser","Chrome");

    }

    @AfterAll
    static void teardown(){
        extent.flush(); // Very important never forget to flush (No report otherwise)
    }

    @Test
    public void passingTestSample(){
        test = extent.createTest("My First Trial Report", "I will Have Better insigth ...");
        test.info("Test started");

        // basic test logic
        int expected =10;
        int actual = 5+5;
        if (expected==actual){
            test.pass("The operation was correct :" + expected+ " = "+ actual);
        } else {
            test.fail("The operation was wrong :" + expected+ " not equal "+ actual);
        }
        test.info("Test is completed");
    }

    @Test
    public void failingTestSample(){
        test = extent.createTest("My Failing Trial Report", "I will Have Better insigth ...");
        test.info("Test started");

        // basic test logic
        int expected =10;
        int actual = 5+4;
        if (expected==actual){
            test.pass("The operation was correct :" + expected+ " = "+ actual);
        } else {
            test.fail("The operation was wrong :" + expected+ " not equal "+ actual);
        }
        test.info("Test is completed");
    }
}
