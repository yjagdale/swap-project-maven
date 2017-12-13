package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends Browser{

	@Override
	public WebDriver getBrowser() {
		 return driver=new FirefoxDriver();
	}

}
