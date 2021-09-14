@Smoke
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able to retrieve data from DataBase
  So I can manage it

  Scenario: Count users that has specific occupation and age
    When Select users with occupation "Plumber" and age > 30 years, there are 2 users in result set

  Scenario: Select users and companies with specific filter
    When Select users with occupation "Tester" and companies with employers number < 100 in same city - there is "Mercy" in "Company 5" in result

  Scenario: Delete row in DataBase
    Given There is a row in companies table with company name "Company 44"
    When Delete row where company name is "Company 44"
    Then There is no row where company name is "Company 44"

  Scenario: Create new table using script file
    When I create new table
    Then New table appears in DataBase