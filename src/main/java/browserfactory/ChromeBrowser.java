package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser extends Browser {

	@Override
	public WebDriver getBrowser() {
		 return driver=new ChromeDriver();
	}

}
