package StepDefinitionFiles;

import java.time.Duration;
import java.util.List;

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

public class SuccesfulLoginWithDataTable 
{
	private WebDriverWait wait;
	
	//Create methods base on Cucumber Feature File
	@Given("User is on Login Page3")
	public void user_is_on_login_page3() throws Exception 
	{
		wait = new WebDriverWait(WebDriverHandler.AutoDriver, Duration.ofSeconds(10));
		String targetURL = "https://demoqa.com/login";
		System.out.println("Navigating to: [" + targetURL + "]");
		WebDriverHandler.AutoDriver.navigate().to(targetURL);
	}
	
	@When("^User enters Credentials3$")
	public void user_enters_and3(DataTable credentials) 
	{
		List<List<String>> data = credentials.cells();
		
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
		WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		
		System.out.println("Clearing login fields... ");
		Username.clear();
		Password.clear();
		
		System.out.println("Setting username: [" + data.get(0).get(0) + "]...");
		Username.sendKeys(data.get(0).get(0));
		
		System.out.println("Setting password: [" + data.get(0).get(1) + "]...");
		Password.sendKeys(data.get(0).get(1));
	}
	
	@When("Click Login3")
	public void click_login3() 
	{
		WebElement Login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
		System.out.println("Clicking login... ");
		Login.click();
	}
	
	@Then("^Userlabel with Credentials will be displayed3$")
	public void userlabel_with_will_be_displayed3(DataTable credentials) 
	{
		List<List<String>> data = credentials.cells();
		
		System.out.println("Verify logged user label... ");
		WebElement Label = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='userName-value']")));
		String actualValue = Label.getText().trim();
		Assert.assertEquals(actualValue , data.get(0).get(0));
	}
}
