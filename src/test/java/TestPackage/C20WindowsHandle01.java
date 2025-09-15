package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C20WindowsHandle01 extends TestBase {

/*
    Open empty window
    Go to https://www.google.com/ in the open tab
    Create new tab
    Go to https://www.linkedin.com/ in the open tab
    Create new window
    Go to https://clarusway.com/ in the window that opens
*/


    @Test
    void name() {
        //    Open empty window
        driver.get("about:blank");
        String firstWinHandle = driver.getWindowHandle();
        System.out.println("firstWinHandle = " + firstWinHandle);

        //    Open a new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        String secondWindowHandle = driver.getWindowHandle();

        //    Go to https://www.google.com/ in the open tab

        driver.get("https://www.google.com/");

        //    Create new tab
        driver.switchTo().newWindow(WindowType.TAB);
        String thirdWindowHandle = driver.getWindowHandle();

        //    Go to https://www.linkedin.com/ in the open tab
        driver.get("https://www.linkedin.com/");

        //    Create new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        String forthWindowHandle = driver.getWindowHandle();

        //    Go to https://clarusway.com/ in the window that opens
        driver.get("https://clarusway.com/");
    }
}
