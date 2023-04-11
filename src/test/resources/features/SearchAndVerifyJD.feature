Feature: Search for Job and verify Job description

  Background:
    Given I am on the home page

  @test
  Scenario Outline:
    When I accept the cookie

    And I search for the job "Software Engineering, Director"


    And I filter the results of the search with the below values
      | Experience level   | Employment Type   | Location   |
      | <Experience level> | <Employment Type> | <Location> |

    And I click on "select"

    And I click on "view Job description"

    Then I am able to verify JD successfully with below values
      | Experience Level | Type      |
      | Manager          | Full time |


    Examples:
      | Experience level | Employment Type | Location   |
      | Manager          | Full Time       | Manchester |


