Feature: test Sign Up

  Scenario: Press Sign up button, check if Sign up windows pops up
    When I press Sign up button in the main page
    And I should see sign up pop up

  Scenario: Check if sing up window could be re-opened
    When I press Sign up button in the main page
    Then I should see sign up pop up
    Then I close sign up pop up window
    Then I press Sign up button in the main page
    And I should see sign up pop up

  Scenario: Sign up with random User name and password
    When I press Sign up button in the main page
    Then I register with user name and password 'random'
    Then I press sign up button
    And I see sign up message 'success'

#    //Negative

  Scenario: Try to Sign up without User name and password
    When I press Sign up button in the main page
    Then I press sign up button
    And I see sign up message 'unsuccess'

  Scenario: Try to Sign up with existing user
    When I press Sign up button in the main page
    Then I register with user name and password 'existing'
    Then I press sign up button
    And I see sign up message 'exists'