package pages;

import or.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetails {

    WebDriver browser;

    By itemCondition = ObjectRepository.getORObject("itemCondition");
    By timeLeft = ObjectRepository.getORObject("timeLeft");
    By itemPrice = ObjectRepository.getORObject("itemPrice");
    By itemLabel = ObjectRepository.getORObject("itemLabel");
    By itemSeller = ObjectRepository.getORObject("itemSeller");
    By addToCard = ObjectRepository.getORObject("addToCard");

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
