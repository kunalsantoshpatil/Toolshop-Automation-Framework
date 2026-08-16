Feature: User Login
Background:
  Given user is on Home Page
  And user click on signIn button
#
#  Scenario: Login with valid credentials
#    When user should enter Registered email
#    And user should enter Registered password
#    And user click on login button
#    And user should login successfully
#    Then user should click on logout

#  Scenario Outline: Testing login functionality with valid and invalid credentials
#    When user enter email "<email>" and password "<password>"
#    And user click on login button
#    Then user should see "<expectedResult>"
#
#    Examples:
#      | email         | password    | expectedResult            |
#      | abc@gmail.com | Kunal@$3424 | Invalid email or password |
#      | abc gmail.com | abc123      | Email format is invalid   |
#      |               | parya#212   | Email is required         |
#      | fun@gmail.com |             | Password is required      |
#
