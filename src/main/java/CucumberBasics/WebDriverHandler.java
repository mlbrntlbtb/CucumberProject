package CucumberBasics;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHandler 
{
	public static WebDriver AutoDriver;
	public static WebDriver CreateBrowser(String browserName) throws Exception
	{
		
		switch(browserName.toLowerCase()) 
		{
			case "chrome":
				AutoDriver = WebDriverManager.chromedriver().create();
				break;
		
			case "firefox":
				AutoDriver = WebDriverManager.firefoxdriver().create();
				break;
		
			default:
				throw new Exception("Browser: [" + browserName + "] does not exist.");
		}
		return AutoDriver;
	}
}
