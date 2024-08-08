package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features", glue= {"StepDefinitions"},
monochrome = true,
plugin = {"pretty", "junit:target/jUnit Reports/report.xml"}
//tags="@smokeTest"
//"pretty", html:target/Html Reports/htmlReport.html
// "pretty", json:target/json Report/report.json
		)
public class TestRunner {

}
