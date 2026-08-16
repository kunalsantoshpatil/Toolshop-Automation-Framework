#Feature: checkout functionality
#
#  Background:
#    Given user has searched the product
#    And user has added product to the cart
#    And user is on view cart section
#
#    When user click on proceed to checkout
#    And click on first Continue as guest
#    And enter guest emailID,firstname,lastname
#    And click on second Continue as guest
#    And user click on second proceed to checkout
#    And enter billing address
#    And user click on third proceed to checkout
#
#  Scenario:Verify successful payment with COD
#    When user choose payment method "Cash on Delivery"
#    And click on confirm
#    Then "Payment was successful" message should come
#
#  Scenario: verify successful payment with credit card
#    When user choose payment method "Credit Card"
#    And enter credit card number
#    And enter expiration date
#    And enter CVV
#    And enter card holder name
#    And click on confirm
#    Then "Payment was successful" message should come
#
#  Scenario: verify successful payment with Bank Transfer
#    When user choose payment method "Bank Transfer"
#    And enter Bank Name
#    And enter Account Name
#    And enter Account Number
#    And click on confirm
#    Then "Payment was successful" message should come
#
#  Scenario: verify successful payment with Buy Now Pay Later
#    When user choose payment method "Buy Now Pay Later"
#    And select any monthly installment option
#    And click on confirm
#    Then "Payment was successful" message should come
#
#
#
#
