package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class C34RobotClass03 extends TestBase {
    /*
       Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
       Copy h1 element's text and paste it into username input
       Click enter
       Scroll page down
       Scroll page up
       (Don't use click() and sendKeys() methods)
    */
    @Test
    public void robotClassTaskTest() throws AWTException, InterruptedException {

        Robot robot = new Robot();
        robot.setAutoDelay(200);

        //Go to https://testpages.eviltester.com/styled/basic-html-form-test.html
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");

        //Copy h1 element's text and paste it into username input
        String h1Text = driver.findElement(By.tagName("h1")).getText();
        System.out.println("h1Text = " + h1Text);

        // Clipboard and Robot operations...
        StringSelection ss = new StringSelection(h1Text);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        // For Mac users , To change focus back to Browser
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);


        // Press three times Tab button to select name field


        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

        //Scroll page down
        robot.mouseWheel(500);
        //Scroll page upv
        robot.mouseWheel(-500);


    }

}
