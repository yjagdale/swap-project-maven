package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    WebDriver browser;

    By confirmationMessage = By.xpath(".//span[contains(text(), ' was just added to your cart.')]");

    public ShoppingCart(WebDriver browser){
        this.browser = browser;
    }
    public WebElement getConfirmationMessage() {
        return browser.findElement(confirmationMessage);
    }


}
