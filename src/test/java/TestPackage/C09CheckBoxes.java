package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C09CheckBoxes {
    WebDriver driver;


    @Test
    void checkBoxTest01() {
        String url = "https://the-internet.herokuapp.com/checkboxes";
        By checkBox1ByXpath = By.xpath("//input[@type='checkbox'][1]");
        By checkBox2ByXpath = By.xpath("//input[@type='checkbox'][2]");
        By checkBoxesByXpath = By.xpath("//input[@type='checkbox']");


      // Go to https://the-internet.herokuapp.com/checkboxes
        driver.get(url);
      // Locate the elements of checkboxes.
        WebElement checkBox1 = driver.findElement(checkBox1ByXpath);
        WebElement checkBox2 = driver.findElement(checkBox2ByXpath);

      // Then click on checkbox 1 if box is not selected.
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }

      // Then click on checkbox 2 if box is not selected.
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

      // Then verify that checkbox 1 is checked.
        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertTrue(checkBox2.isSelected());

        // Additional notes:
        // Lets Check if all checkboxes are selected:

        List<WebElement> checkBoxList = driver.findElements(checkBoxesByXpath);

        for (WebElement checkBox : checkBoxList){
            Assertions.assertTrue(checkBox.isSelected());
        }
        checkBoxList.forEach(t-> System.out.println(t.isSelected()));
    }


    @Test
    void checkBoxTest02() {
        String url = "https://demoqa.com/checkbox";
        By checkBoxByXpath = By.xpath("//span[@class='rct-checkbox']//*[contains(@class,'rct-icon rct-icon')]");

      // Go to URL: https://demoqa.com/
      // Click on Elements.

        driver.get(url);
      // Click on Checkbox.
        WebElement checkBox = driver.findElement(checkBoxByXpath);
        checkBox.click();

      // Verify if Home checkbox is selected.
        checkBox = driver.findElement(checkBoxByXpath);

        Assertions.assertTrue(!checkBox.getDomAttribute("class").contains("uncheck"));
        checkBox = driver.findElement(checkBoxByXpath);
        checkBox.click();

        checkBox = driver.findElement(checkBoxByXpath);
        Assertions.assertTrue(checkBox.getDomAttribute("class").contains("uncheck"));

      // Verify that "You have selected" is visible.


    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
