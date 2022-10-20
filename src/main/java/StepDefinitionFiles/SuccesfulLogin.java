package StepDefinitionFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CucumberBasics.WebDriverHandler;
import io.cucumber.java.en.*;

public class SuccesfulLogin 
{
	private WebDriverWait wait;
	private String username = "johnwick";
	private String password = "Excommunicado123!";
	
	//Create methods base on Cucumber Feature File
	@Given("User is on Login Page")
	public void user_is_on_login_page() throws Exception 
	{
		wait = new WebDriverWait(WebDriverHandler.AutoDriver, Duration.ofSeconds(10));
		String targetURL = "https://demoqa.com/login";
		System.out.println("Navigating to: [" + targetURL + "]");
		WebDriverHandler.AutoDriver.navigate().to(targetURL);
	}
	
	@When("User enters UserName and Password")
	public void user_enters_user_name_and_password() 
	{
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
		WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		
		System.out.println("Clearing login fields... ");
		Username.clear();
		Password.clear();
		
		System.out.println("Setting username: [" + username + "]...");
		Username.sendKeys(username);
		
		System.out.println("Setting password: [" + password + "]...");
		Password.sendKeys(password);
	}
	
	@And("Click Login")
	public void click_login() 
	{
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		System.out.println("Clicking login... ");
		Login.click();
	}
	
	@Then("Userlabel with UserName will be displayed")
	public void userlabel_with_user_name_will_be_displayed() 
	{
		System.out.println("Verify logged user label... ");
		WebElement Label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));
		String actualValue = Label.getText().trim();
		Assert.assertEquals(actualValue , username);
	}
}
