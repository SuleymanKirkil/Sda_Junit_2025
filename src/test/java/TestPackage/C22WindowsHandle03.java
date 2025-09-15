package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C22WindowsHandle03 extends TestBase {

    /*
Go to URL: https://the-internet.herokuapp.com/windows
Verify the text: “Opening a new window”
Verify the title of the page is “The Internet”
Click on the “Click Here” button
Verify the new window title is “New Window”
Go back to the previous window and then verify the title: “The Internet”
*/

    String expectedHeading = "Opening a new window";
    String url = "https://the-internet.herokuapp.com/windows";
    By headingByXpath = By.xpath("//h3[.='Opening a new window']");
    By clickHereBylinkText = By.linkText("Click Here");
    @Test
    void test() {
        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.get(url);

        //Verify the text: “Opening a new window”
        Assertions.assertEquals(expectedHeading,driver.findElement(headingByXpath).getText());

        //Verify the title of the page is “The Internet”
        Assertions.assertTrue(driver.getTitle().equals("The Internet"));

        //Click on the “Click Here” button
        driver.findElement(clickHereBylinkText).click();

        //Verify the new window title is “New Window”
        String handle1 = driver.getWindowHandle();

        Set<String> handlesSet = driver.getWindowHandles();
        //List<String> handleList = new ArrayList<>(handlesSet);

        String handle2= null;
        for (String handle:handlesSet){
            if (!handle.equals(handle1)){
                handle2= handle;
            }
        }

        driver.switchTo().window(handle2);
        Assertions.assertTrue(driver.getTitle().equals("New Window"));

        //Go back to the previous window and then verify the title: “The Internet”

    }
}
