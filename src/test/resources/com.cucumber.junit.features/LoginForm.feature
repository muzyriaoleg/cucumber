Feature: As a user I want to login with username and password

  @smoke
  Scenario Outline: Account page should contain login form and logins user in case right username/password
    Given the user opens account page
    When the user types "<userEmail>" in userEmail input
    And the user types "<password>" in password input
    And the user press Sign in button
    Then My Account button appears
      Examples:
      |userEmail|password|
      |olegmuzyria89@gmail.com|GlacialCascad31!|
      |test1@gmail.com|pass2|