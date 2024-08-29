Feature: checkout flow

  Scenario: I add one item to the cart and proceed with the checkout
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I go to phones section
    Then I pick an item 'Samsung galaxy s6'
    Then I press Add to cart button
    Then I see success message for adding the product to the cart
    Then I press on cart button in the main page
    Then I see the same product that I added 'Samsung galaxy s6'
    Then I place an order
    Then I check if all fields are visible
    Then I add user information to the checkout page 'all'
    Then I click on purchase button
    And I see order confirmation

#    //Negative

  Scenario: I add one item to the cart and proceed with the checkout without adding all user information
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I go to phones section
    Then I pick an item 'Samsung galaxy s6'
    Then I press Add to cart button
    Then I see success message for adding the product to the cart
    Then I press on cart button in the main page
    Then I see the same product that I added 'Samsung galaxy s6'
    Then I place an order
    Then I check if all fields are visible
    Then I add user information to the checkout page 'few'
    Then I click on purchase button
    And I see checkout message