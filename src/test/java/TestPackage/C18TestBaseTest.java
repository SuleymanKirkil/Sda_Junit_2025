package TestPackage;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C18TestBaseTest extends TestBase {
    @Test
    void test01() {
        driver.get("https://www.linkedIn.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
    }
    @Test
    void test02() {
        driver.get("https://www.instagram.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

    }
    @Test
    void test03() {
        driver.get("https://www.google.com");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
}
