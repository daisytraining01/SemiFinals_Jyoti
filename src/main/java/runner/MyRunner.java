package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)				
@CucumberOptions(features="src\\main\\java\\Features",
glue={"step_def"},
tags ="@demo",
dryRun=false,
monochrome=true
)
public class MyRunner {
	

}
