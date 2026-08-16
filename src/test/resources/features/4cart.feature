Feature: Add To Cart

  Background:
    Given user is on Home Page
    When multiple products should get displayed
    And user search valid product "Hammer" in search box
    And click on search icon
    And user click on random product
    Then respective product description page should displayed

  Scenario: Add product to cart successfully
    When user click on Add to cart button
    Then "Product added to shopping cart." this msg should come

  Scenario: stored product in view cart section
    When user click on Add to cart button
    Then "Product added to shopping cart." this msg should come
    And user click on view cart
    Then verify product has stored in view cart

    Scenario: Increase or Decrease product quantity
      When user click on Add to cart button
      When Increase or Decrease product quantity
      Then price should also change

  Scenario: remove product from the cart
    When user click on Add to cart button
    Then "Product added to shopping cart." this msg should come
    And user click on view cart
    Then verify product has stored in view cart
    When user click on remove product from the cart
    Then verify "Product deleted." message should come
