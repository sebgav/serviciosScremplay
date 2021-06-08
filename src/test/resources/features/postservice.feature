Feature: Register user through api

  Scenario Outline: Registration user failed
    Given "Jan" create a user with the post method in "https://gorest.co.in/"
    When provide information the post method with "public-api/users"
      | name   | <name>   |
      | gender | <gender> |
      | email  | <email>  |
      | status | <status> |
    Then visualize the status <code> of service "public-api/users/"
    Examples:
      | name    | gender | email            | status | code |
      | ronaldo | Male   | ronal7@mail.com | Active | 200  |
