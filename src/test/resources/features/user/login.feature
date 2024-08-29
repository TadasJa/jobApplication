Feature: test login

  Scenario: Press Login button, check if Login windows pops up
    When I press Login button in the main page
    And I should see Login pop up

  Scenario: Check if Login window could be re-opened
    When I press Login button in the main page
    Then I should see Login pop up
    Then I close Login pop up window
    When I press Login button in the main page
    And I should see Login pop up

  Scenario: Login with existing User name and password
    When I press Login button in the main page
    Then I Login with user name and password 'existing'
    Then I press Login button
    And I see that user is Logged in


    #    //Negative

  Scenario: Try to Login without User name and password
    When I press Login button in the main page
    Then I press Login button
    And I see Login message 'noValues'

  Scenario: Login with random User name and password
    When I press Login button in the main page
    Then I Login with user name and password 'random'
    Then I press Login button
    And I see Login message 'notExisting'
