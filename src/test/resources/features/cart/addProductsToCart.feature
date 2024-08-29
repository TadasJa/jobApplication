Feature: testing product import to cart

  Scenario: I add one item to the cart
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I go to phones section
    Then I pick an item 'Samsung galaxy s6'
    Then I press Add to cart button
    Then I see success message for adding the product to the cart
    Then I press on cart button in the main page
    And I see the same product that I added 'Samsung galaxy s6'

  Scenario: I remove one item from the cart
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I press on cart button in the main page
    Then I remove the product that was added previously 'Samsung galaxy s6'
    And I check if the cart is empty

  Scenario: Add multiple items to the cart
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I go to phones section
    Then I pick an item 'Samsung galaxy s6'
    Then I press Add to cart button
    Then I see success message for adding the product to the cart
    Then I press on home page button
    Then I go to laptop section
    Then I pick an item 'Sony vaio i5'
    Then I press Add to cart button
    Then I see success message for adding the product to the cart
    Then I press on cart button in the main page
    And I see the same product that I added 'Samsung galaxy s6'
    And I see the same product that I added 'Sony vaio i5'

  Scenario: I remove all items from the cart
    When I press Login button in the main page
    Then I should see Login pop up
    Then I Login with user name and password 'existing'
    Then I press Login button
    Then I press on cart button in the main page
    Then I remove the product that was added previously 'Samsung galaxy s6'
    Then I remove the product that was added previously 'Sony vaio i5'
    And I check if the cart is empty




