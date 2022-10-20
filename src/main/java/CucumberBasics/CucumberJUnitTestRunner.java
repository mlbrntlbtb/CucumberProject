package CucumberBasics;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( //Cucumber options are properties/settings 
		features="FeatureFiles" //Path for feature files
		//features="C:\\Users\\Melbourne\\eclipse-workspace\\CucumberProject\\FeatureFiles\\CucumberParameterWithExample.feature"
		,glue= {"StepDefinitionFiles"} //Path for step definition files
		//,dryRun=true //If set to true, will only check step in feature file with corresponding code in step definition file
		//,monochrome=true //If set to true, more readable output console
		,tags="@LoginActionUsingBackground" //Defines or groups what feature or scenario in step definition files we want Cucumber to execute
		//,tags= "@LoginAction or @LoginActionParameterWithExample or @LoginActionParameterWithoutExample or @LoginActionDataTable or @LoginActionDataTableMaps"
		//,tags= "@LoginAction and not @LoginActionParameterWithExample" 
		//,plugin= {"pretty"} //Set output reports with additional colors and stack traces errors
		//,plugin="{html:Folder_Name}" //Generates HTML report at the location mentioned
		//,plugin= {"json:Folder_Name/cucumber.json"} //Generates reports including gherkin sources in JSON format -- processed by Cucumber Jenkins
		//,plugin= {"junit:Folder_Name/cucumber.xml"} //Generates reports as XML using JUnits report task -- understood by CI servers to generate visual reports
		,plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class CucumberJUnitTestRunner 
{

}
