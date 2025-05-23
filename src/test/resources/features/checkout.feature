@Checkout
Feature: Checkout
  As a shopper
  I want to finalise and complete my purchase
  So that I can receive my ordered books

  @Happy
  Scenario: Successful checkout
    Given I am logged in with username "Username29405" and password "Password1"
    And I already have "Rough Magic: Riding the World's Loneliest Horse Race" in the cart
    And I am on the Checkout page
    When I fill in the shipping address form with the following details:
      | Name | Address Line 1 | Address Line 2 | Pincode | State |
      | Name | Address Line 1 | Address Line 2 | 100000  | State |
    And I click the Place Order button
    Then I see the Order placed successfully!!! toast message
    And I should be redirected to the My Order Details page
    And I see my latest order listed with today's date and total "₹8,264.00"

  @Sad
  @ClearCart
  Scenario: Unsuccessful checkout - not logged in
    Given I already have "Rough Magic: Riding the World's Loneliest Horse Race" in the cart
    And I am on the Shopping Cart page
    When I click the CheckOut button
    Then I should be redirected to the Login page

  @Sad
  @ClearCart
  Scenario: Unsuccessful checkout - missing shipping address fields
    Given I am logged in with username "Username12" and password "Password1"
    And I already have "Rough Magic: Riding the World's Loneliest Horse Race" in the cart
    And I am on the Checkout page
    When I leave all field in the form empty
    Then I see the validation error messages
