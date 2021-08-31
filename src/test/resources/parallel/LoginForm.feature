@Parallel
@Regression
Feature: Login with valid userEmail/password
  As a registered user
  I want to be able to login
  So I can manage my account preferences

  Scenario: Account page should contain login form and logins user in case right username/password
    Given The user opens Account page
    When the user types olegmuzyria89@gmail.com in userEmail input
    And the user types GlacialCascad31! in password input
    And the user press Sign in button
    Then My Account button appears