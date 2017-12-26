package browserfactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser extends Browser {

    @Override
    public WebDriver getBrowser() {
        DesiredCapabilities dr = null;
        dr=DesiredCapabilities.chrome();
        dr.setBrowserName("chrome");
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(System.getProperty("hubURL")), dr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

}
