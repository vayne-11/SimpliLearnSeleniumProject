Feature: Adding products to cart feature
    As a user
    I want to add item to buy to the cart

    Scenario: 3. Find the most expensive dress and add it to the cart
        Given I am on the sign in page
            And I sign in with valid credentials
        When I add the most expensive dress to the cart
        Then I should see the cart update