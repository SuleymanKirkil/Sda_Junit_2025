package TestPackage;


import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class C32RobotClass01 {
    @Test
    public void robotClassKeyboardTest1() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // This pause is given so that we can click on the script. Robot will write "sout" on the screen
        Thread.sleep(5000);

        robot.keyPress(KeyEvent.VK_S); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_S);

        robot.keyPress(KeyEvent.VK_O); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_O);

        robot.keyPress(KeyEvent.VK_U); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_U);

        robot.keyPress(KeyEvent.VK_T); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_T);

        robot.keyPress(KeyEvent.VK_ENTER); // after pressing a key dont forget to release
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Select All
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(2000);

        // Copy the selected text
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(2000);

        // Delete
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.delay(2000);

        // Paste the copied text
        robot.keyPress(KeyEvent.VK_META); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);

    }

    @Test
    public void robotClassKeyboardTest2(){
        String text = "google.com";

        try {
            Robot robot = new Robot();
            Thread.sleep(4000);

            // How to print String value by robot
            for (Character ch:text.toCharArray()){
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(ch));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(ch));
                robot.delay(200);
            }

            // We can run tes by keyboard short cuts FOR MACS :
            robot.keyPress(KeyEvent.VK_CONTROL); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(2000);
/*    for Wins:
            robot.keyPress(KeyEvent.VK_CONTROL); // for Win users robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_F10);
            robot.keyRelease(KeyEvent.VK_F10);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_CONTROL);

 */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
