package pages;

import or.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private final WebDriver browser;
    By resultLink = ObjectRepository.getORObject("resultLink");

    By resultCount = ObjectRepository.getORObject("resultCount");

    String filterScreenSize = ".//a[@class = 'search-guidance__text-item-link']//div[text() = '{{startRange}}\" - {{endRange}}\"']";

    By rangeArea = ObjectRepository.getORObject("rangeArea");

    By filterKeys = ObjectRepository.getORObject("filterKeys");

    public WebElement getRangeArea() {
        return browser.findElement(rangeArea);
    }


    public SearchResult(WebDriver browser) {
        this.browser = browser;
    }

    public WebElement getResultCount() {
        return browser.findElement(resultCount);
    }

    public List<WebElement> getAllResults() {
        return browser.findElements(resultLink);
    }

    public WebElement getFilterScreenSize(String startRange, String endRange) {
        filterScreenSize = filterScreenSize.replace("{{startRange}}", startRange).replace("{{endRange}}", endRange);
        return browser.findElement(By.xpath(filterScreenSize));
    }

    public WebElement filteredKey() {
        return browser.findElement(filterKeys);
    }

    public List<String> getResultText() {
        List<String> textOfProduct = new ArrayList<>();
        List<WebElement> results = getAllResults();
        for (int i = 0; i < results.size(); i++) {
            textOfProduct.add(results.get(i).getText());
        }
        return textOfProduct;
    }
}
