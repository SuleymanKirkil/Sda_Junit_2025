package TestPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C35Cookies extends TestBase {
    /*
        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        Get Cookie.
        Find the total number of cookies.
        Print all the cookies.
        Add Cookie.
        Edit Cookie.
        Delete Cookie.
        Delete All Cookies.
     */
    @Test
    public void cookiesTest() {

//        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

//        Print all the cookies.
        System.out.println("------------- ALL COKIES ----------------");
        Set <Cookie> cookieSet = driver.manage().getCookies();
        cookieSet.forEach(System.out::println);

//        Get Cookie.
        Cookie firstCookie = driver.manage().getCookieNamed("protein");
        System.out.println("firstCookie = " + firstCookie);

//        Find the total number of cookies.
        int numOfCookies = cookieSet.size();
        System.out.println("numOfCookies = " + numOfCookies);

//        Add Cookie.
        Cookie newCookie = new Cookie("sweet","sugar");
        driver.manage().addCookie(newCookie);
        System.out.println("---------After new Cookşe Added ----------------");
        driver.manage().getCookies().forEach(System.out::println);

//        Delete Cookie.
        driver.manage().deleteCookie(newCookie);
        System.out.println("---------After new Cookie is Deleted ----------------");
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().deleteCookieNamed("vegetable");
        System.out.println("---------After vegetables cookie is Deleted ----------------");
        driver.manage().getCookies().forEach(System.out::println);

//        Delete All Cookies.
        driver.manage().deleteAllCookies();
        System.out.println("---------After all cookies are deleted ----------------");
        driver.manage().getCookies().forEach(System.out::println);

 }

}
