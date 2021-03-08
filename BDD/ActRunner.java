package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"Stepdefinition"},
    tags = "@HRMAct3",
    plugin= {"html:Reports/htmlreports.html"},
    monochrome=true
    )

public class ActRunner {
	
	

}