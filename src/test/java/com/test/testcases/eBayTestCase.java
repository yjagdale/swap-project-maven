package com.test.testcases;

import DataMappers.ProductDetailsObject;
import browserfactory.BrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.ExecutionData.ExecutionData;
import com.test.readers.PropertiesReader;
import com.test.utilis.CommonUtils;
import com.test.utilis.CoreUtils;
import com.test.utilis.Utils;
import com.test.utilis.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductDetails;
import pages.SearchResult;
import pages.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class eBayTestCase {

    WebDriver browser;
    PropertiesReader pReader;
    ExtentReports extent;
    ExtentTest logger;
    private String reportLocation = "./target/" + Utils.getDateTimeStamp() + ".html";

    @BeforeSuite
    public void startSuite() {
        pReader = new PropertiesReader();
        browser = BrowserFactory.createBrowser();
        WaitUtils.setBrowser(browser);
        browser.get(pReader.getProperty("url"));
        extent = new ExtentReports(reportLocation, true);
        browser.manage().timeouts().implicitlyWait(Integer.parseInt(pReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        browser.manage().window().maximize();
    }

    @Test(priority = 0)
    public void searchProduct() {
        logger = extent.startTest("Search Product Test Case");
        System.out.println("Test Case");
        HomePage homePage = new HomePage(browser);
        SearchResult searchResult = new SearchResult(browser);
        CoreUtils.sendKeys(homePage.getSearchInputField(), pReader.getProperty("productSearch"));
        CoreUtils.click(homePage.getsearchButton());
        logger.log(LogStatus.PASS, "Searched for product", "Searched for product");
        CoreUtils.waitUntillVisible(searchResult.getResultCount(), 60);
        CoreUtils.scrollToVisible(searchResult.getRangeArea());
        CoreUtils.click(searchResult.getFilterScreenSize("50", "60"));
        CoreUtils.waitUntillVisible(searchResult.filteredKey(), 40);
        logger.log(LogStatus.PASS, "Filtered results", "Out of all results filtered the results");
        List<String> resultAssert = new ArrayList<String>();
        resultAssert.add("sony");
        resultAssert.add("tv");
        Assert.assertTrue(CommonUtils.assertResultContains(searchResult.getResultText(), resultAssert));
        logger.log(LogStatus.PASS, "Search for product is completed");
    }

    @Test(priority = 1)
    public void validateFilterResult() {
        logger = extent.startTest("Validate Filter result");
        List<String> resultAssert = new ArrayList<String>();
        for (int i = 50; i <= 60; i++) {
            resultAssert.add("" + i);
        }
        resultAssert.add("sony");
        SearchResult searchResult = new SearchResult(browser);
        Assert.assertTrue(CommonUtils.assertResultContains(searchResult.getResultText(), resultAssert));
        logger.log(LogStatus.PASS, "Result validated successfully");
    }

    @Test(priority = 2)
    public void clickOnRandomProduct() {
        logger = extent.startTest("Select Random product and go to product details page");
        SearchResult searchResult = new SearchResult(browser);
        List<WebElement> result = searchResult.getAllResults();
        int productIndex = (int) (Math.random() * (result.size() - 0));
        CoreUtils.click(result.get(productIndex));
        logger.log(LogStatus.PASS, "Selected Random product and navigated to product details page");
    }

    @Test(priority = 3)
    public void validateProductDetailsPage() {
        logger = extent.startTest("Validate Product details page and store details");
        ProductDetails productDetails = new ProductDetails(browser);
        WaitUtils.waitForElementToVisible(productDetails.getItemLabel(), 20);
        ProductDetailsObject productDetailsObject = new ProductDetailsObject();
        logger.log(LogStatus.PASS, "Product details page is opened");
        productDetailsObject.setPrice(productDetails.getItemPrice().getText());
        productDetailsObject.setProductName(productDetails.getItemLabel().getText());
        productDetailsObject.setSellerName(productDetails.getItemSeller().getText());

        logger.log(LogStatus.PASS, "Product details stored successfully", "Details are " + productDetailsObject.toString());

        ExecutionData.storeObject("Product_Sony", productDetailsObject);
        System.out.println(productDetails.getItemCondition().getText());
        Assert.assertTrue(productDetails.getItemCondition().getText().length() > 0);
        try {
            String productTime = productDetails.getTimeLeft().getText();
            Pattern pattern = Pattern.compile("/[[0-9]*d]* [0-9]*h|[[0-9]*h]* [0-9]*m|[[0-9]*m]* [0-9]*s/");
        } catch (Exception ee) {

        }
        CoreUtils.click(productDetails.getaddToCard());
        logger.log(LogStatus.PASS, "Click on add to cart button");
        ShoppingCart shoppingCart = new ShoppingCart(browser);
        Assert.assertTrue(shoppingCart.getConfirmationMessage().isDisplayed());
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
            logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        }
        extent.endTest(logger);
    }

    @AfterSuite
    public void closeTest() {
        extent.flush();
        browser.quit();
        extent.close();
        System.out.println("Report has been stored at " + reportLocation);
    }
}
