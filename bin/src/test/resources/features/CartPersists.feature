Feature: Cart is saved saved feature
    As a user
    I want my cart to be saved when I sign out

Background: Add an item to the cart and logout
    Given I am on the sign in page
    And I sign in with valid credentials
    When I add the most expensive dress to the cart
    And I logout

    Scenario: 4. Sign in and verify cart was saved
          Given I am on the sign in page
          When I sign in with valid credentials
          Then I should see my shopping cart