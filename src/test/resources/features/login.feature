Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid email and password
    And the user clicks the login button
    Then the user should be logged in successfully
    And the logout link should be displayed
    And the "Logged in as" text should display the correct username