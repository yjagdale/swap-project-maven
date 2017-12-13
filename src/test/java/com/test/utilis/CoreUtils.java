package com.test.utilis;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.test.utilis.WaitUtils.browser;

public class CoreUtils {
    public static void sendKeys(WebElement element, String text) {
        if (!isVisible(element)) {
            WaitUtils.waitForElementToVisible(element);
        }
        element.sendKeys(text);
    }

    private static boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }

    public static void click(WebElement element) {
        if (!isVisible(element)) {
            WaitUtils.waitForElementToVisible(element);
        }
        element.click();
    }

    public static void waitUntillVisible(WebElement element, int timeToWait) {
        WaitUtils.waitForElementToVisible(element, timeToWait);
    }

    public static void scrollToVisible(WebElement rangeArea) {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("arguments[0].scrollIntoView(true);",rangeArea);
        js = null;
    }
}
