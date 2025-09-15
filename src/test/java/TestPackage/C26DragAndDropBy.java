package TestPackage;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C26DragAndDropBy extends TestBase {
    /*
    Go to URL: https://rangeslider.js.org/
    Shift 100 units to the right and 100 units to the left on the horizontal axis.

     */

    By sliderHandleByXpath = By.xpath("//div[@id='js-rangeslider-0']//div[@class='rangeslider__handle']");
    String url = "https://rangeslider.js.org/";

    @Test
    public void dragAndDropByTest() {

        //Go to URL: https://rangeslider.js.org/
        driver.get(url);
        //Shift 100 units to the right and 100 units to the left on the horizontal axis.
        Actions action = new Actions(driver);

        action
                .dragAndDropBy(driver.findElement(sliderHandleByXpath),52,0)
                .dragAndDropBy(driver.findElement(sliderHandleByXpath),-52,0)
                .perform(); // 204 - 152 = 52 pixels
    }

}
