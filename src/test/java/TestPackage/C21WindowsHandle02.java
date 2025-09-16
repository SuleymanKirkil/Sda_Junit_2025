package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C21WindowsHandle02 extends TestBase {

   /*
    Open browser
    Create a new tab
    Create a new window
    Open https://www.linkedin.com/ in the second tab
    Open https://clarusway.com/ in the last window
    Open https://www.youtube.com/ in the first tab
    */


    @Test
    void name() {
         //    Open browser
        String handle01 = driver.getWindowHandle();

        //    Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        String handle02 = driver.getWindowHandle();

        //    Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String handle03 = driver.getWindowHandle();

        //    Open https://www.linkedin.com/ in the second tab
        driver.switchTo().window(handle02).get("https://www.linkedin.com/");

        //    Open https://clarusway.com/ in the last window
        driver.switchTo().window(handle03).get("https://clarusway.com/");


        //    Open https://www.youtube.com/ in the first tab
        driver.switchTo().window(handle01).get("https://www.youtube.com/");

    }
}
