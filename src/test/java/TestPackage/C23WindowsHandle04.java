package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C23WindowsHandle04 extends TestBase {

    /*
        Open https://www.google.com/ in the opened tab
        Create a new tab
        Open https://www.instagram.com/ in the opened window
        Create a new window
        Open https://www.linkedin.com/ in the opened tab
        Switch to the instagram tab and write 'You found the instagram tab' in the email area
*/

    @Test
    void test() throws InterruptedException {
        //        Open https://www.google.com/ in the opened tab
        driver.get("https://www.google.com/");

        //        Create a new tab
        driver.switchTo().newWindow(WindowType.TAB);

        //        Open https://www.instagram.com/ in the opened window
        driver.get("https://www.instagram.com/");
        Thread.sleep(2000);

        //        Create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);

        //        Open https://www.linkedin.com/ in the opened tab
        driver.get("https://www.linkedin.com/");

        //        Switch to the instagram tab and write 'You found the instagram tab' in the email area
        Set<String> handleSet = driver.getWindowHandles();

      /*
       List<String> handleList = new ArrayList<>(handleSet);
       driver.switchTo().window(handleList.get(1));
        System.out.println(driver.getCurrentUrl());
*/

        String expectedTerm = "instagram";
        String instaHandle = null;

        for (String handle : handleSet){
            driver.switchTo().window(handle);
            String url = driver.getCurrentUrl();
            if (url.contains(expectedTerm)){
                instaHandle = handle;
            }
        }
        driver.switchTo().window(instaHandle);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//button[@class='_a9-- _ap36 _a9_1']")).click();
        driver.findElement(By.xpath("//label[@class='_aa48']")).sendKeys("You found the instagram tab");

    }
}
