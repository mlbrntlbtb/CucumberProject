package StepDefinitionFiles;

import CucumberBasics.WebDriverHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;

public class CucumberHooks 
{
	@Before //@BeforeAll //@Before(order=0) //Hook order -- before starts with 0 to higher
	public static void Initialize() throws Exception 
	{
		WebDriverHandler.CreateBrowser("Chrome");
		WebDriverHandler.AutoDriver.manage().window().maximize();
	}
	
	@After //@AfterAll //@After(order=0) //Hook order -- after starts with higher to 0
	public static void Teardown() 
	{
		WebDriverHandler.AutoDriver.quit();
	}
	
	//Tagged Hooks
	@Before("@SampleTag") //Will run before specific tagged feature/scenario
	//@Before("@SampleTag or SampleTag2")
	public static void SampleInitialize()
	{
		//
	}
	
	@After("@SampleTag") //Will run after specific tagged feature/scenario
	//@After("@SampleTag or SampleTag2")
	public static void SampleTeardown()
	{
		//
	}
}