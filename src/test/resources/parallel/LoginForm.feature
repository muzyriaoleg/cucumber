Feature: Login with valid userEmail/password
  As a registered user
  I want to be able to login
  So I can manage my account preferences

  @smoke
  Scenario Outline: Account page should contain login form and logins user in case right username/password
    Given The user opens Account page
    When the user types <userEmail> in userEmail input
    And the user types <password> in password input
    And the user press Sign in button
    Then the user is redirected to "Welcome page"
      Examples:
      |userEmail|password|
      |olegmuzyria89@gmail.com|GlacialCascad31!|