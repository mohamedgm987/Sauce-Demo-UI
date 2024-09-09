Feature: Purchase flow on sauceDemo
  Scenario: Successful purchase of most expensive products
    Given I open the SauceDemo website orderflow
    When I login with username "standard_user" and password "secret_sauce" orderflow
    Then I should be on the products page orderflow
    And I add the two most expensive products to the cart orderflow
    When I click on the cart button orderflow
    Then I should be on the cart page and the selected products should be displayed orderflow
    When I click on the checkout button orderflow
    Then I should be on the checkout page orderflow
    When I fill in the checkout form with first name "John", last name "Doe", and zip code "12345" orderflow
    And I click on the continue button orderflow
    Then I should be on the overview page orderflow
    And the items total before taxes should be displayed orderflow
    And the URL should match "https://www.saucedemo.com/checkout-step-two.html" orderflow
    When I click on the finish button orderflow
    Then I should see the "Thank you for your order!" and "Your order has been dispatched, and will arrive just as fast as the pony can get there!" messages orderflow
