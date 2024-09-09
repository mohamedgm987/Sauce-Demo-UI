package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/orderFlow.feature",
    glue = "scenariosImplementation",
    plugin = {"pretty","html:target/cucumber-reports/secondScenario.html"},
    monochrome = true
)

public class OrderFlow {

}
