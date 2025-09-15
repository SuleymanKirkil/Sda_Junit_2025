package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
TestBase Class:
We create this class to avoid repeating the same setup and teardown code
in every test class. It uses Java’s OOP (Object-Oriented Programming) concept
of inheritance.

Key points:

1. Reusability:
   - Any class that extends TestBase automatically gets access to the driver,
     setup(), and teardown() methods.
   - Child classes don’t need to write these methods again.

2. Access Modifier:
   - TestBase is usually placed in a separate package.
   - To allow child classes to use the driver, it must be declared
     as public or protected.
   - We choose "protected" since only child classes need it, not external classes.

3. Abstract Class:
   - We don’t want anyone to create objects of TestBase directly.
   - To prevent this, we declare TestBase as abstract.
   - Abstract classes can’t be instantiated; they can only be inherited.

4. Usage:
   - We will extend TestBase in our test classes.
   - The driver variable and common methods are inherited,
     which keeps our code shorter, cleaner, and easier to maintain.
*/

public abstract class TestBase {
    protected WebDriver driver;
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
