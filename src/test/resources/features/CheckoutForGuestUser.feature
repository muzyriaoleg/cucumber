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
      | Thinking in Java                                                      |
      | Thinking Recursively with Java                                        |
      | Java and Algorithmic Thinking for the Complete Beginner (2nd Edition) |
    When I click 'Add to basket' button for product with name Think Java
    And I select 'Basket/Checkout' in basket pop-up
    Then I am redirected to the "Basket page"
    And Basket order summary is as following:
      | Delivery cost | Total   |
      | FREE          | 31,74 € |
    When I click 'Checkout' button on 'Basket' page
    Then I am redirected to the "Checkout page"
    When I click 'Buy now' button
    Then the following validation error messages are displayed on 'Delivery Address' form:
      | Form field name | validation error message                               |
      | Email address    | Please enter your email address                       |
      | Full name       | Please enter a first and last name                    |
      | Address line 1  | Please enter your address line 1                      |
      | Town/City       | Please enter your town/city                           |
      | Postcode/ZIP    | Please enter your postcode/ZIP or write 'No Postcode' |
    And Checkout order summary is as following:
      | Sub-total | Delivery | VAT    | Total   |
      | 89,71 €   | FREE     | 0,00 € | 89,71 € |
    And I checkout as a new customer with email test@user.com
    When I fill delivery address information manually:
      | fullName | deliveryCounty | addressLine1     | addressLine2     | townCity | countyState  | postCode |
      | John     | Ukraine        | Random address 1 | Random address 2 | Kyiv     | Random State | 12345    |
    And I click 'Buy now' button
    Then there is no validation error messages displayed on 'Delivery Address' form
    When I click 'Buy now' button again
    And the following validation error messages are displayed on 'Payment' form:
      | Your card number is not valid., Invalid, Invalid |
    When I enter my card details
      | cardType    | Visa             |
      | nameOnCard  | RandomName       |
      | cardNumber  | 4111111111111111 |
      | expiryYear  | 2022             |
      | expiryMonth | 03               |
      | cvv         | 123              |