package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "src/test/resources/features/firstScenario.feature",
	    glue = {"scenariosImplementation"},
	    plugin = {"pretty", "html:target/cucumber-reports/FirstScenario.html"},
	    monochrome = true
	)
	public class FirstScenarioRunner {
	}


