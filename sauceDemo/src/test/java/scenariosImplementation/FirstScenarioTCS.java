package scenariosImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import io.cucumber.java.en.*;
public class FirstScenarioTCS {

	    WebDriver driver;

	    @Given("I open the SauceDemo website test runner")
	    public void i_open_the_saucedemo_website_testrunnner() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\death\\eclipse-workspace\\sauceDemo\\chromedriver.exe"); 
	        driver = new ChromeDriver();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @When("I attempt to login with username {string} and password {string} test runner")
	    public void i_attempt_to_login_with_username_and_password_testrunnner(String username, String password) {
	        driver.findElement(By.id("user-name")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("login-button")).click();
	    }

	    @Then("I should see the error message {string} test runner")
	    public void i_should_see_the_error_message_testrunnner(String expectedErrorMessage) {
	        String actualErrorMessage = driver.findElement(By.cssSelector(".error-message-container")).getText();
	        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	        driver.quit();
	    }
	}

