Feature: SauceDemo Login

  Scenario Outline: Login with invalid credentials test runner
    Given I open the SauceDemo website test runner
    When I attempt to login with username "<username>" and password "<password>" test runner
    Then I should see the error message "<errorMessage>" test runner

    Examples:
      | username       | password        | errorMessage                                    |
      | invalid_user   | wrong_password  | Epic sadface: Username and password do not match any user in this service |
      |                | secret_sauce    | Epic sadface: Username is required               |
      | standard_user  |                 | Epic sadface: Password is required               |
