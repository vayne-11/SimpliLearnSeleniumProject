Feature: Login Feature
    As a existing user
    I want to be able to sign in

    Scenario: 2. Login as existing user
        Given I am on the sign in page
        When I sign in with valid credentials
        Then I should be on my account page
