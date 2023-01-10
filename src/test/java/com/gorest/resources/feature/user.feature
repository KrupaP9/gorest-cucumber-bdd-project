Feature: Testing User creation and verifying all data

  Scenario Outline: Create a new user data
    Given As a user I create new user
    When I create a new user by  information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Then I got valid status code
    Examples:
      | name  | email                | gender | status |
      | freya | freyanames@gmail.com | Female | Active |


  Scenario: Get User details
    When I get user information
    Then i verify valid status code

  Scenario Outline: Update  user details data
    Given As a user I update user
    When Update user details by  the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Then i verify code
    Examples:
      | name   | email             | gender | status |
      | anjali | anjalis@gmail.com | Female | Active |


  Scenario: Delete user details
    When i deleted user successfully
    Then I get valid code








