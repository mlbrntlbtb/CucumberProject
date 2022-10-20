package CucumberBasics;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="FeatureFiles"
		,glue="StepDefinitionFiles"
		,tags= "@LoginActionUsingBackground"
		//,tags="@LoginAction or @LoginActionParameterWithExample or @LoginActionParameterWithoutExample or @LoginActionDataTable or @LoginActionDataTableMaps"
		//,tags= "@LoginAction and not @LoginActionParameterWithExample" 
		,plugin={"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests
{

}
