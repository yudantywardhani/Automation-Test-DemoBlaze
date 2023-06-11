Feature: feature to test login functionality

  Background: User in home page
    Given browser is open
    And user is on home page
    And user set delay 5 seconds
    When user click login button
    And user set delay 5 seconds
    Then verified login form

  @PositiveTestCase
  Scenario Outline: Test login function sucess
    And user set delay 5 seconds
    When user inputs <username> and <password> login
    And user set delay 5 seconds
    And user clicks on login process button
    And user set delay 5 seconds
    Then verified login sucessful
    And close browser

    Examples: 
      | username | password |
      | test     | test     |

  @NegativeTestCase1
  Scenario Outline: Test login function failed with username and pass empty
    And user set delay 5 seconds
    And user clicks on login process button
    And user set delay 5 seconds
    When dialog box is displayed
    Then verified login failed cause username and pass empty 
    And close browser

  @NegativeTestCase2
  Scenario Outline: Test login function failed with wrong password
    And user set delay 5 seconds
    When user inputs <username> and <password> login
    And user set delay 5 seconds
    And user clicks on login process button
    And user set delay 10 seconds
    When dialog box is displayed
    Then verified login failed cause wrong password
    And close browser

    Examples: 
      | username | password    |
      | test     | P@ss0806235 |
