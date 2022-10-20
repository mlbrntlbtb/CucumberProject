package StepDefinitionFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CucumberBasics.WebDriverHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuccesfulLoginWithParameters 
{
	private WebDriverWait wait;
	
	//Create methods base on Cucumber Feature File
	@Given("User is on Login Page2")
	public void user_is_on_login_page2() throws Exception 
	{
		wait = new WebDriverWait(WebDriverHandler.AutoDriver, Duration.ofSeconds(10));
		
		String targetURL = "https://demoqa.com/login";
		System.out.println("Navigating to: [" + targetURL + "]");
		WebDriverHandler.AutoDriver.navigate().to(targetURL);
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_and(String username, String password) 
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
	
	@When("Click Login2")
	public void click_login2() 
	{
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		System.out.println("Clicking login... ");
		Login.click();
	}
	
	@Then("^Userlabel with \"(.*)\" will be displayed$")
	public void userlabel_with_will_be_displayed(String username) 
	{
		System.out.println("Verify logged user label... ");
		WebElement Label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));
		String actualValue = Label.getText().trim();
		Assert.assertEquals(actualValue , username);
	}
}
