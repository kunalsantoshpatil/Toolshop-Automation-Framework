Feature:Register feature

  Background:
    Given user is on Home Page
    And user click on signIn button
    And click on register link
    And I enter valid firstname and Lastname
    And I enter the DOB
    And I enter valid address

  Scenario: Register with valid credentials
    And I enter valid email address
    And I enter valid password
    When click on Register button
    Then my account should be created successfully

#  Scenario: Register with already existed email
#    When I enter already existed email address
#    And I enter Registered password
#    And click on Register button
#    Then my account should not created successfully
#
#  Scenario: Register with empty password filed
#    When I enter already existed email address
#    And click on Register button
#    Then "Password is required" message should see successfully