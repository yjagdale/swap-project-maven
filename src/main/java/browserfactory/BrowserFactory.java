package browserfactory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    public static WebDriver createBrowser() {
        System.out.println("Using " + System.getProperty("browserType") + "Browser for execution");
        switch (System.getProperty("browserType").toUpperCase()) {
            case "CHROME":
                return new ChromeBrowser().getBrowser();
            case "FIREFOX":
                return new FirefoxBrowser().getBrowser();
            default:
                return null;
        }


    }
}
