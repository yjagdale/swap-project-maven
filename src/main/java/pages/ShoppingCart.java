package pages;

import or.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    WebDriver browser;

    By confirmationMessage = ObjectRepository.getORObject("confirmationMessage");

    public ShoppingCart(WebDriver browser) {
        this.browser = browser;
    }

    public WebElement getConfirmationMessage() {
        return browser.findElement(confirmationMessage);
    }


}
