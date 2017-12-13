package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails {

    WebDriver browser;

    By itemCondition = By.id("vi-itm-cond");
    By timeLeft = By.id("vi-cdown_timeLeft");
    By itemPrice = By.id("prcIsum");
    By itemLabel = By.id("itemTitle");
    By itemSeller = By.cssSelector("#mbgLink > span");
    By addToCard = By.id("isCartBtn_btn");

    public ProductDetails(WebDriver browser) {
        this.browser = browser;
    }

    public WebElement getItemCondition() {
        return browser.findElement(itemCondition);
    }

    public WebElement getTimeLeft() {
        return browser.findElement(timeLeft);
    }

    public WebElement getItemPrice() {
        return browser.findElement(itemPrice);
    }

    public WebElement getItemLabel() {
        return browser.findElement(itemLabel);
    }

    public WebElement getItemSeller() {
        return browser.findElement(itemSeller);
    }

    public WebElement getaddToCard() {
        return browser.findElement(addToCard);
    }
}
