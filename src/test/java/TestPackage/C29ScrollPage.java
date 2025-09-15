package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C29ScrollPage extends TestBase {
    /*
    Go to "https://browserstack.com"
    Scroll page down with 'down arrow' key
    Scroll page down with 'page down' key
    Scroll page up with 'page up' key
    Scroll page up with 'up arrow' key
     */
By testimonialsBy = By.id("testimonials-body");
    @Test
    public void scrollTest() throws InterruptedException {


//Go to "https://linkedin.com"
    driver.get("https://www.browserstack.com/");
        Actions actions = new Actions(driver);

//Scroll page down with 'down arrow' key
    actions
            .sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ARROW_DOWN)
            .perform();

// Scroll page down with 'page down' key
    actions
            .sendKeys(Keys.PAGE_DOWN)
            .perform();

//Scroll page up with 'up arrow' key


//Scroll page up with 'page up' key
        actions
                .sendKeys(Keys.PAGE_UP)
                .perform();

//Scroll page down with 'space' key
        actions
                .sendKeys(Keys.SPACE)
                .perform();

//Scroll to buttom of the page


//Scroll to view of an elemet
        actions
                .scrollToElement(driver.findElement(testimonialsBy))
                .perform();

        Thread.sleep(3000);

        Thread.sleep(3000);
//Scroll to top of the page


//Scroll with moveToElemet
        actions
                .moveToElement(driver.findElement(testimonialsBy))
                .perform();


        //Scroll by some amount down
        actions
                .scrollByAmount(0,200) // this scrolls down
                .perform();
        //Scroll by some amount up
        actions
                .scrollByAmount(0,-200) // this scrolls down
                .perform();

    }


}
/*

 */
