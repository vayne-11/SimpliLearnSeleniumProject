Feature: Create Account feature
    As a new user
    I want to be able to sign up

    Scenario: 1. Create a new user account
        Given I am on the sign up page
        When I create a new account
        Then I should be on my account page