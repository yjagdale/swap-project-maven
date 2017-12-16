package pages;

import or.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    By searchInputField = ObjectRepository.getORObject("searchInputField");

    By searchButton = ObjectRepository.getORObject("searchButton");
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
