package com.test.utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
	public static void click(WebDriverWait wait,WebDriver driver,WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}
