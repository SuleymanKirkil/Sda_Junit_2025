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

public class C12Dropdown02 {
    WebDriver driver;

    String url = "https://the-internet.herokuapp.com/dropdown";
    By dropDownById = By.id("dropdown");


    @Test
    void oldDropDownMenuTest() {

    //Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.get(url);
        Select select = new Select(driver.findElement(dropDownById));

    //Create method selectByIndexTest and Select Option 1 using index .

        selectByIndexTest(select,1);

    //Create method selectByValueTest Select Option 2 by value.
        WebElement selectedOpt = selectByValueTest(select,"2");
        Assertions.assertTrue(selectedOpt.getText().contains("Option 2"));

    //Create method selectByVisibleTextTest Select Option 1 value by visible text.
        selectByVisibleTextTest(select,"Option 1");

    //Create method printAllTest Print all dropdown value.
        printAllTest(select);

    //Verify the dropdown has Option 2 text.
        List <WebElement> options = select.getOptions();
        boolean hasOption2= false;
        for (WebElement opt: options){
            if (opt.getText().equals("Option 2")){
                hasOption2=true;
                break;
            }
        }
        Assertions.assertTrue(hasOption2);

    //Create method printFirstSelectedOptionTest Print first selected option.

    //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
    Assertions.assertEquals(3,options.size(),"Expected Is Not Equal Actual");
    //Assertions.assertEquals(2,options.size(),"Expected Is Not Equal Actual");
    }

    private void printAllTest(Select select) {
        List<WebElement> allOptions = select.getOptions();
        allOptions.forEach(t -> System.out.println(t.getText()));
    }

    private void selectByVisibleTextTest(Select select, String s) {
        select.selectByVisibleText(s);
    }

    private WebElement selectByValueTest(Select select, String number) {
        select.selectByValue(number);
        return select.getFirstSelectedOption();
    }

    private void selectByIndexTest(Select select, int idx) {
        select.selectByIndex(idx);
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
