/*
 * ================================================================================
 * 🎯 EXTENTREPORTS SIMPLE ANALOGY FOR BEGINNERS
 * ================================================================================
 * 
 * Think of ExtentReports like a SCHOOL SYSTEM:
 * 
 * 🏢 ExtentReports = SCHOOL PRINCIPAL
 *    - Role: Main boss who manages everything
 *    - What it does: "I coordinate all the reports from all classes"
 *    - Code: ExtentReports extent = new ExtentReports();
 *    - Example: Like a school principal who oversees all students and classes
 * 
 * 📝 ExtentSparkReporter = SECRETARY  
 *    - Role: Creates beautiful HTML report files
 *    - What it does: "I write down everything in a nice HTML document"
 *    - Code: ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
 *    - Example: Like a secretary who takes notes and creates official documents
 * 
 * 📋 ExtentTest = STUDENT NOTEBOOK
 *    - Role: Individual record book for each test
 *    - What it does: "I only record the story of ONE specific test"
 *    - Code: ExtentTest test = extent.createTest("Test Name");
 *    - Example: Like a student's notebook - only that student's grades are written
 * 
 * 🔄 HOW THEY WORK TOGETHER:
 * 
 * 1. Principal (ExtentReports): "We need to collect exam results this semester!"
 * 2. Secretary (ExtentSparkReporter): "OK principal, I'll prepare a beautiful report"
 * 3. Student Notebooks (ExtentTest): Each student has their own separate notebook
 * 
 * 🎨 VISUAL STRUCTURE:
 * 
 * 🏢 ExtentReports (Factory)
 *     ├── 📝 ExtentSparkReporter (HTML Writing Machine)
 *     └── 📋 ExtentTest (Test Notebooks)
 *         ├── Test 1 notebook: "Google search test"
 *         ├── Test 2 notebook: "Login test"  
 *         └── Test 3 notebook: "Checkout test"
 * 
 * 💻 IN ACTION:
 * 
 * // 1. Principal hires secretary
 * extent.attachReporter(sparkReporter);
 * 
 * // 2. Open new notebook for each test
 * ExtentTest test = extent.createTest("Math Exam");
 * 
 * // 3. Write notes in the notebook
 * test.pass("Question 1 correct!");
 * test.fail("Question 2 wrong!");
 * 
 * // 4. Secretary collects all notebooks and creates final report
 * extent.flush(); // ← VERY IMPORTANT!
 * 
 * 🎯 RESULT: A beautiful HTML file that tells the story of your tests!
 * 
 * 💡 KEY TAKEAWAY:
 * - ExtentReports = Manager (coordinates everything)
 * - ExtentSparkReporter = Writer (creates HTML file)
 * - ExtentTest = Individual story teller (records one test's journey)
 * 
 * ⚠️ DON'T FORGET: Always call extent.flush() at the end, or your secretary 
 *    won't save the report file!
 * 
 * ================================================================================
 */

package TestPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class C52ExtentReportsAnalogyExample {
    
    //  The Principal - manages everything
    private static ExtentReports extent;
    
    //  The Secretary - writes HTML reports
    private static ExtentSparkReporter sparkReporter;
    
    //  The Student Notebook - one per test
    private ExtentTest test;
    @BeforeAll
    public static void setupReports() {
        //  Hire the secretary (HTML writer)
        sparkReporter = new ExtentSparkReporter("logs/school-report.html");
        
        //  Create the principal (main coordinator)
        extent = new ExtentReports();
        
        //  Principal tells secretary: "You're hired!"
        extent.attachReporter(sparkReporter);
        
        //  Add some school information
        extent.setSystemInfo("School", "Automation Academy");
        extent.setSystemInfo("Principal", "Mr. ExtentReports");
        extent.setSystemInfo("Secretary", "Ms. SparkReporter");
    }
    @Test
    public void runSampleTest() {
        //  Open a new student notebook for this test
        test = extent.createTest("English Exam", "Student needs to pass reading test");
        
        // ✍️ Write what happened in the notebook
        test.info(" Student entered the classroom");
        test.info(" Exam paper distributed");
        test.pass(" Student answered question 1 correctly");
        test.pass(" Student answered question 2 correctly");
        test.fail(" Student got question 3 wrong");
        test.info(" Student submitted the exam");
        
        // The notebook now contains the complete story of this test!
    }
    @AfterAll
    public static void finishReports() {
        //  Principal tells secretary: "Please create the final report now!"
        if (extent != null) {
            extent.flush();
        }
        
        System.out.println(" School report created: school-report.html");
        System.out.println(" Check the file to see all student results!");
    }
}

/*
 * Copy this analogy and remember it when coding with ExtentReports!
 * It will help you understand why we need all three components.
 */