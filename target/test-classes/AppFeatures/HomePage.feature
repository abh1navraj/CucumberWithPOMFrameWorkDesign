Feature: Home Page Feature

  Background: 
    Given user is already logged in to the application
      | username  | password   |
      | rohitr357 | Rohit@1999 |

  Scenario: Home Page Title
    Given user is on Home Page
    When user gets the title of the page
    Then title should be "ParaBank | Accounts Overview"

  Scenario: Account Overview
    Given user is on Home Page
    Then "Accounts Overview" section should be present

  Scenario: Log out option
    Given user is on Home Page
    Then Log out button should be displayed

  Scenario: Log out
    Given user is on Home Page
    And user click on Log out button
    Then user should get Logged out from home page
    And Page title should be "ParaBank | Welcome | Online Banking"
