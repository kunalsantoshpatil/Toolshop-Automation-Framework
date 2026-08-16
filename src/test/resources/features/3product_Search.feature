#Feature: Product Search
#
#  Background:
#    Given user is on Home Page
#
#  Scenario: Verifying product description page
#    When multiple products should get displayed
#    And user click on random product
#    Then valid product description page should displayed
#
#  Scenario: Search valid product in search box and validate
#    When user search valid product "Hammer" in search box
#    And click on search icon
#    And user click on random product
#    Then respective product description page should displayed
#
#  Scenario: Search Invalid product in search box and validate
#    When user search Invalid product in search box
#    Then "There are no products found." message should displayed
#
#  Scenario: Verify product search by filter
#    When click on random checkbox add filter
#    Then validate respective products are showing or not