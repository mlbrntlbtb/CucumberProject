package CucumberBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberBaseTest 
{
	private static WebDriver AutoDriver;
	public static void main (String[] args) 
	{
		AutoDriver = WebDriverManager.chromedriver().create();
		AutoDriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(AutoDriver, Duration.ofSeconds(10));
		
		String targetURL = "https://demoqa.com/login";
		System.out.println("Navigating to: [" + targetURL + "]");
		AutoDriver.navigate().to(targetURL);
		
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
		WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		
		System.out.println("Clearing login fields... ");
		Username.clear();
		Password.clear();
		
		String username = "johnwick";
		String password = "Excommunicado123!";
		
		System.out.println("Setting username: [" + username + "]...");
		Username.sendKeys(username);
		
		System.out.println("Setting password: [" + password + "]...");
		Password.sendKeys(password);
		
		System.out.println("Clicking login... ");
		Login.click();
		
		System.out.println("Verify logged user label... ");
		WebElement Label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));
		String actualValue = Label.getText().trim();
		Assert.assertEquals(actualValue , username);
		
		System.out.println("Logging out... ");
		WebElement Logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']")));
		Logout.click();
		
		AutoDriver.quit();
	}
}
