@Regression
Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    When I open the "Initial home page"
    And I search for Think Java
    And I am redirected to a "Search page"
    And Search results contain the following products
      | Think Java             |
      | Thinking Java Part I   |
      | Core Java Professional |
    And I apply the following search filters
      | Price range  | 30 € +         |
      | Availability | In Stock (8)   |
      | Language     | English (40)   |
      | Format       | Paperback (45) |
    Then Search results contain only the following products
      | Think Java                                                            |
      | Thinking Recursively with Java                                        |
      | Java and Algorithmic Thinking for the Complete Beginner (2nd Edition) |
    When I click 'Add to basket' button for product with name Think Java
    And I select 'Basket/Checkout' in basket pop-up
    Then I am redirected to the "Basket page"
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 31,40 € |