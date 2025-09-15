package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    /**
     * Scrolls the page by a given number of pixels.
     */
    public static void scrollByPixels(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    /**
     * Scrolls to the specified element.
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls to the bottom of the page.
     */
    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Scrolls to the top of the page.
     */
    public static void scrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    /**
     * Clicks on the specified element using JavaScript.
     */
    public static void clickElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Sets a value into an input field.
     */
    public static void setValue(WebDriver driver, WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    /**
     * Highlights the specified element with a red border.
     */
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    /**
     * Returns the page title.
     */
    public static String getPageTitle(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return document.title;");
    }

    /**
     * Checks if the page has fully loaded.
     */
    public static boolean isPageLoaded(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.readyState;").equals("complete");
    }

    /**
     * Displays a JavaScript alert with the given message.
     */
    public static void showAlert(WebDriver driver, String message) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert(arguments[0]);", message);
    }

    /**
     * Opens a new browser tab with the given URL.
     */
    public static void openNewTab(WebDriver driver, String url) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0],'_blank');", url);
    }

    /**
     * Refreshes the current page.
     */
    public static void refreshPage(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location.reload();");
    }

    /**
     * Returns the value entered in a form element
     * (e.g., input, textarea, select).
     */
    public static String getInputValue(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].value;", element);
    }

    /**
     * Returns the text content of a non-form element
     * (e.g., div, span, p).
     */
    public static String getText(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].textContent;", element);
    }

    /**
     * Returns the value of the specified attribute of an element.
     */
    public static String getAttributeValue(WebDriver driver, WebElement element, String attribute) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", element, attribute);
    }
}
