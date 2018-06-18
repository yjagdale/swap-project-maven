package browserfactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends Browser {

    @Override
    public WebDriver getBrowser() {
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver();
    }

}
