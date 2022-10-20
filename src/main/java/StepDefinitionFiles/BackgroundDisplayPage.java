package StepDefinitionFiles;

import CucumberBasics.WebDriverHandler;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BackgroundDisplayPage 
{
	public String landingPage;
	
	@Given("User navigated on landing page")
	public void user_navigated_on_landing_page() 
	{
		landingPage = WebDriverHandler.AutoDriver.getCurrentUrl();
	}
	
	@Then("Landing page should be displayed")
	public void landing_page_should_be_displayed() 
	{
		System.out.println("Landing page: [" + landingPage + "]");
	}
}
