package scenariosImplementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.*;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;

public class OrderFlowScenario {
	
	 	WebDriver driver;
	    WebDriverWait wait;

	    @Given("I open the SauceDemo website orderflow")
	    public void i_open_the_saucedemo_website_orderflow() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\death\\eclipse-workspace\\sauceDemo\\chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://www.saucedemo.com/");
	    }

	    @When("I login with username {string} and password {string} orderflow")
	    public void i_login_with_username_and_password_orderflow(String username, String password) {
	        driver.findElement(By.id("user-name")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("login-button")).click();
	    }

	    @Then("I should be on the products page orderflow")
	    public void i_should_be_on_the_products_page_orderflow() {
	        WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
	        Assert.assertEquals("Products", productsTitle.getText());
	    }

	    @And("I add the two most expensive products to the cart orderflow")
	    public void i_add_the_two_most_expensive_products_to_the_cart_orderflow() throws InterruptedException {
	        Select sortingDropdown = new Select(driver.findElement(By.className("product_sort_container")));
	        sortingDropdown.selectByVisibleText("Price (high to low)");
	        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
	        addToCartButtons.get(0).click();  
	        addToCartButtons.get(1).click(); 
	    }

	    @When("I click on the cart button orderflow")
	    public void i_click_on_the_cart_button_orderflow() {
	        driver.findElement(By.className("shopping_cart_link")).click();
	    }

	    @Then("I should be on the cart page and the selected products should be displayed orderflow")
	    public void i_should_be_on_the_cart_page_and_selected_products_should_be_displayed_orderflow() {
	        WebElement cartTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
	        Assert.assertEquals("Your Cart", cartTitle.getText());
	        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
	        Assert.assertTrue(cartItems.size() == 2);
	    }

	    @When("I click on the checkout button orderflow")
	    public void i_click_on_the_checkout_button_orderflow() {
	        driver.findElement(By.id("checkout")).click();
	    }

	    @Then("I should be on the checkout page orderflow")
	    public void i_should_be_on_the_checkout_page_orderflow() {
	        WebElement checkoutTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
	        Assert.assertEquals("Checkout: Your Information", checkoutTitle.getText());
	    }

	    @When("I fill in the checkout form with first name {string}, last name {string}, and zip code {string} orderflow")
	    public void i_fill_in_the_checkout_form_with_first_name_last_name_and_zip_code_orderflow(String firstName, String lastName, String zipCode) {
	        driver.findElement(By.id("first-name")).sendKeys(firstName);
	        driver.findElement(By.id("last-name")).sendKeys(lastName);
	        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
	    }

	    @And("I click on the continue button orderflow")
	    public void i_click_on_the_continue_button_orderflow() {
	        driver.findElement(By.id("continue")).click();
	    }

	    @Then("I should be on the overview page orderflow")
	    public void i_should_be_on_the_overview_page_orderflow() {
	        WebElement overviewTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
	        Assert.assertEquals("Checkout: Overview", overviewTitle.getText());
	    }

	    @And("the items total before taxes should be displayed orderflow")
	    public void the_items_total_before_taxes_should_be_displayed_orderflow() {
	        WebElement itemTotal = driver.findElement(By.className("summary_subtotal_label"));
	        Assert.assertTrue(itemTotal.isDisplayed());
	    }

	    @And("the URL should match {string} orderflow")
	    public void the_url_should_match_orderflow(String expectedUrl) {
	        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
	    }

	    @When("I click on the finish button orderflow")
	    public void i_click_on_the_finish_button_orderflow() {
	        driver.findElement(By.id("finish")).click();
	    }

	    @Then("I should see the {string} and {string} messages orderflow")
	    public void i_should_see_the_and_messages_orderflow(String thankYouMessage, String dispatchMessage) {
	        WebElement thankYouElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
	        WebElement dispatchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-text")));
	        Assert.assertEquals(thankYouMessage, thankYouElement.getText());
	        Assert.assertEquals(dispatchMessage, dispatchElement.getText());
	        driver.quit();
	    }
}
