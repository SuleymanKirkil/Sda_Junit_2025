package TestPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C11Dropdown {
    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
    By dropdownById = By.id("oldSelectMenu");
    By multiSelectDropdownById = By.id("cars");


    @Test
    void oldDropDownMenuTest() {

        driver.get(url);
        WebElement dropdownElement = driver.findElement(dropdownById);

        Select select = new Select(dropdownElement);

        // Select 2nd option from dropdown:
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        // Select option which has value of "red":
        select.selectByValue("red");
        System.out.println(select.getFirstSelectedOption().getText());

        // Select according to visible text:
        select.selectByVisibleText("Purple");
        System.out.println(select.getFirstSelectedOption().getText());

        // Check if the dropdown is multi-select
        System.out.println(select.isMultiple());

    }

    @Test
    void multiSelectTest() {
        driver.get(url);
        WebElement multiSelect = driver.findElement(multiSelectDropdownById);

        Select select = new Select(multiSelect);

        // Select 2nd option from dropdown:
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.deselectAll();

        // Select option which has value of "volvo"
        select.selectByValue("volvo");
        System.out.println(select.getFirstSelectedOption().getText());
        Assertions.assertTrue(select.getFirstSelectedOption().getText().contains("Volvo"));

        // Select according to visible text:
        select.selectByVisibleText("Audi");
        List<WebElement> selectedCars = select.getAllSelectedOptions();
        selectedCars.forEach(t-> System.out.println(t.getText()));

        System.out.println(selectedCars.get(0).getText());
        System.out.println(selectedCars.get(1).getText());

        // verify that Opel is one of the options
        List<WebElement> options = select.getOptions();
        boolean hasOpel = false;
        for (WebElement option:options){
            if (option.getText().equals("Opel")){
                hasOpel = true;
                break; // when it founds Opel loop will be broken
            }
        }
        Assertions.assertTrue(hasOpel);
        Assertions.assertEquals(4, options.size());

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
