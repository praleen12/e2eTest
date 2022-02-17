package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"stepDefination"},
//plugin = { "pretty", "html:target/cucumber-reports" },
monochrome = true
,plugin = {"pretty", "json:target/cucumber.json"}
//,plugin = { "pretty", "junit:target/junitReports/report.xml"}
//				, plugin = { "pretty", "json:target/JSONReports/cucumber.json"
//, "html:target/HtmlReports" 
//}
		)
public class TestRunner {

}


