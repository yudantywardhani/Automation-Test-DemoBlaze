Feature: feature to test signup functionality

  Background: User in home page
    Given browser is open
    And user is on home page
    And user set delay 5 seconds
    When user click signup button
    And user set delay 5 seconds
    Then verified signup form

  @PositiveTestCase
  Scenario Outline: Test signup function sucess
    And user set delay 5 seconds
    When user inputs <username> and <password>
    And user set delay 5 seconds
    And user clicks on signup button
    And user set delay 5 seconds
    When dialog box is displayed
    Then verified sign up sucessful
    
    Examples: 
      | username    | password    |
      | TEST0806236 | P@ss0806236 |

  @NegativeTestCase
  Scenario Outline: Test signup function failed
    And user set delay 5 seconds
    #And user clear username field
    #And user clear password field
    #And user set delay 5 seconds
    When user inputs <username> and <password>
    And user set delay 5 seconds
    And user clicks on signup button
    And user set delay 5 seconds
    When dialog box is displayed
    Then verified sign up failed

    Examples: 
      | username    | password    |
      | TEST0806236 | P@ss08062356 |
