package TestPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C24Actions extends TestBase {
    /*
    Mouse Actions
    click(): Clicks at the current mouse position.
    doubleClick(): Performs a double-click at the mouse position.
    clickAndHold(): Performs a click without releasing the mouse button.
    contextClick(): Performs a right-click at the current mouse position.
    moveToElement(WebElement target): Moves the mouse pointer to the center of the target element.
    dragAndDrop(WebElement source, WebElement target): Drags the element from the source and drops it at the target location.
    dragAndDropBy(source, xOffset, yOffset): This method clicks the source element, moves it by a certain offset, and then releases the mouse. Offsets are defined by x and y.
        (X = Horizontal Offset, Y = Vertical Offset)
    release(): Releases the left mouse button at the current position.
    perform(): Executes an action. Must be used to complete an action.
    DON’T FORGET TO USE perform()!
*/
        /*
    Go to URL: https://demoqa.com/buttons
    Click the buttons on the page using the Actions Class.
    Verify the texts that appear after the buttons are operated.
*/
    String url = "https://demoqa.com/buttons";
    By doubleClickById = By.id("doubleClickBtn");
    By rightClickBtnById = By.id("rightClickBtn");
    By clickMeById = By.xpath("//button[.='Click Me']");
    By doubleClickMessageById = By.id("doubleClickMessage");
    By rightClickMessageById = By.id("rightClickMessage");
    By dynamicClickMessageById = By.id("dynamicClickMessage");

    @Test
    void test() {

        //    Go to URL: https://demoqa.com/buttons
        driver.get(url);

        Actions actions = new Actions(driver);

        //    Click the buttons on the page using the Actions Class.
        Action doubleClick = actions.doubleClick(driver.findElement(doubleClickById)).build();
        //actions.doubleClick(driver.findElement(doubleClickById)).perform();
        Action rightClick = actions.contextClick(driver.findElement(rightClickBtnById)).build();
        Action dynamicClick = actions.click(driver.findElement(clickMeById)).build();

        //    Verify the texts that appear after the buttons are operated.
        doubleClick.perform();
        Assertions.assertTrue(driver.findElement(doubleClickMessageById).isDisplayed());

        rightClick.perform();
        Assertions.assertTrue(driver.findElement(rightClickMessageById).isDisplayed());

        dynamicClick.perform();
        Assertions.assertTrue(driver.findElement(dynamicClickMessageById).isDisplayed());

    }
}
