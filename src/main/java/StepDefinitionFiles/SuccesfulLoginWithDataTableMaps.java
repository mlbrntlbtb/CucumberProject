package StepDefinitionFiles;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CucumberBasics.WebDriverHandler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuccesfulLoginWithDataTableMaps 
{
	private WebDriverWait wait;
	
	//Create methods base on Cucumber Feature File
	@Given("User is on Login Page4")
	public void user_is_on_login_page4() throws Exception 
	{
		wait = new WebDriverWait(WebDriverHandler.AutoDriver, Duration.ofSeconds(10));
		
		String targetURL = "https://demoqa.com/login";
		System.out.println("Navigating to: [" + targetURL + "]");
		WebDriverHandler.AutoDriver.navigate().to(targetURL);
	}
	
	@When("^User enters Credentials4$")
	public void user_enters_and4(DataTable credentials) 
	{
		List<Map<String, String>> data = credentials.asMaps(String.class,String.class);
		
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
		WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		
		System.out.println("Clearing login fields... ");
		Username.clear();
		Password.clear();
		
		System.out.println("Setting username: [" + data.get(0).get("Username") + "]...");
		Username.sendKeys(data.get(0).get("Username"));
		
		System.out.println("Setting password: [" + data.get(0).get("Password") + "]...");
		Password.sendKeys(data.get(0).get("Password"));
	}
	
	@When("Click Login4")
	public void click_login4() 
	{
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		System.out.println("Clicking login... ");
		Login.click();
	}
	
	@Then("^Userlabel with Credentials will be displayed4$")
	public void userlabel_with_will_be_displayed(DataTable credentials) 
	{
		List<Map<String, String>> data = credentials.asMaps(String.class,String.class);
		
		System.out.println("Verify logged user label... ");
		WebElement Label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));
		String actualValue = Label.getText().trim();
		Assert.assertEquals(actualValue , data.get(0).get("Username"));
	}
}
