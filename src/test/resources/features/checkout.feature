Feature: Checkout functionality

  Background: User has logged in
    Given the user is logged in with "standard_user" and "secret_sauce"
    And the user is on the products page

  Scenario: User completes the checkout process
    Given the cart is empty
    When the user adds 3 items to the cart
    And the user proceeds to the cart page
    And the user proceeds to the checkout page
    And the user fills in buyer information
    And the user continues to the checkout overview page
    And the user finishes the checkout process
    Then the user should see the checkout complete page
    And the header should contain "thank you"