package com.test.hooks;

import browserfactory.BrowserFactory;
import or.ObjectRepository;
import readers.PropertiesReader;
import com.test.utilis.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseHook {

    public PropertiesReader pReader;
    public WebDriver browser;


    @BeforeSuite
    public void startSuite() {
        pReader = new PropertiesReader();
        ObjectRepository.loadRepository();
        browser = BrowserFactory.createBrowser();
        WaitUtils.setBrowser(browser);
        browser.get(pReader.getProperty("url"));
        browser.manage().timeouts().implicitlyWait(Integer.parseInt(pReader.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        browser.manage().window().maximize();
    }

    @AfterSuite
    public void closeTest() {
        browser.quit();
    }
}
