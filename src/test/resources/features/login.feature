Feature: Login functionality

  Background: User landend to login page
    Given the user is on the login page

  Scenario Outline: User attempts to login
    Given the user enters "<username>" and "<password>"
    Then the login should "<result>"

    Examples:
      | username        | password     | result               |
      | standard_user   | secret_sauce | succeed              |
      | locked_out_user | secret_sauce | fail                 |
      |                 | secret_sauce | fail                 |
      | standard_user   |              | fail                 |
