package TestPackage;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C30JavaScriptExecutor extends TestBase {

    @Test
    public void JscriptExecutorTtest1() {
        driver.get("https://google.com");

        // Create JavaScript Executor object
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // We can execute JavaScript Codes with executeScript()
        js.executeScript("document.body.style.backgroundColor = 'lightBlue';");
        js.executeScript("alert('My Own Alert');");

    }

    @Test
    void dummyTest02() throws InterruptedException {
        //Go to URL: https://api.jquery.com/dblclick/
        driver.get("https://api.jquery.com/dblclick/");

        // We need to switch to iframe first
        driver.switchTo().frame(0);
        //Double-click on the blue square at the middle of the page and then write the changed color.
        WebElement blueSquare = driver.findElement(By.xpath("// span[.='Double click the block']//preceding::div"));

        Actions actions = new Actions(driver);

        String colorBeforeDoubleClick = blueSquare.getCssValue("background-color");

        // Scroll to that element by JavaScript codes
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",blueSquare);

        actions.doubleClick(blueSquare).perform();

        String colorAfterDoubleClick = blueSquare.getCssValue("background-color");

        System.out.println("colorBeforeDoubleClick = " + colorBeforeDoubleClick);
        System.out.println("colorAfterDoubleClick = " + colorAfterDoubleClick);

        Assertions.assertEquals("rgba(255, 255, 0, 1)",colorAfterDoubleClick);

        //driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        Thread.sleep(3000);
        // scrollto the top of the page by js
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);

        // scrollto the bottom of the page by js
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);

    }

}
