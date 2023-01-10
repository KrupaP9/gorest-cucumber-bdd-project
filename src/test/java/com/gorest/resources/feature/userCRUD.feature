Feature: User data created in gorest application

  As a user I create,update  and delete details

  Scenario Outline: CRUD Test
    Given As a user I create get and update and delete user
    When I create a new user by providing the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    And I get user information by id
    And Update user details by providing the information name "<name>" email "<email>" gender "<gender>" status "<status>"
    Then The user id deleted successfully

    Examples:
      | name  | email           | gender | status |
      | Kajal | kajal@gmail.com | Female | Active |


