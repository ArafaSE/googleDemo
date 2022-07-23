Feature: As a user i can search and navigate through the search results

  @001
  Scenario Outline: User get some ads items in the search results
    Given I am a non-registered customer
    And I navigate to "<homePageUrl>"
    When I search for an "<searchKeyword>"
    Then I get a list of matching results
    And I get a few ads items results
    And I can verify that all ads items titles are displayed

    Examples:
      | homePageUrl             | searchKeyword  |
      | https://www.google.com/ | Cars in London |