package StepDefinitionFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CucumberBasics.WebDriverHandler;
import io.cucumber.java.en.*;

public class SuccesfulLogout 
{
	private WebDriverWait wait;
	
	@Given("User is on Profile Page")
	public void user_is_on_profile_page() throws Exception 
	{
		wait = new WebDriverWait(WebDriverHandler.AutoDriver, Duration.ofSeconds(10));
		String targetURL = "https://demoqa.com/profile";
		System.out.println("Navigating to: [" + targetURL + "]");
		WebDriverHandler.AutoDriver.navigate().to(targetURL);
	}
	
	@When("User clicks on Logout")
	public void user_clicks_on_logout() 
	{
		System.out.println("Logging out... ");
		WebElement Logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']")));
		Logout.click();
	}
	
	@Then("Login Page will be displayed")
	public void login_page_will_be_displayed() 
	{
		System.out.println("Login page displayed. ");
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
	}
}
