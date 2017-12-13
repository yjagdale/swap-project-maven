package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    By searchInputField = By.cssSelector(".gh-tb.ui-autocomplete-input");

    By searchButton = By.id("gh-btn");
    private WebDriver browser;
    public HomePage(WebDriver browser) {
        this.browser = browser;
    }

    public WebElement getSearchInputField() {
        return browser.findElement(searchInputField);
    }

    public WebElement getsearchButton() {
        return browser.findElement(searchButton);
    }

}
