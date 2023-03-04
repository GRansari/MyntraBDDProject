package vit.automation.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "classpath:features",
		glue="vit.automation.Stepdefs",
		tags="@MultiSearch",
		plugin={"pretty", // to generate reports
	            "html:target/html/htmlreport.html",
	            "json:target/json/file.json",
	            },
		    monochrome=true,   //it remove the garbage foreign character 
	        publish=true,      // it publish the report
	        dryRun=false     //it give the skeleton or step for the stepdefs
	
		
		)
public class TesrtRunner {

}
