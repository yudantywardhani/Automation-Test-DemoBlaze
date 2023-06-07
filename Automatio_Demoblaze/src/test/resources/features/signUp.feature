Feature: feature to test signup functionality

	Background: User in home page
	  Given browser is open 
    And user is on home page
    And user set delay 5 seconds

	@PositiveTestCase
  Scenario Outline: Test signup function
    When user click signup button
    And user set delay 5 seconds
    Then verified signup form
    When user inputs <username> and <password>
    And user set delay 5 seconds
    And user clicks on signup button
    And user set delay 5 seconds
    When dialog box is displayed
    Then user clicks the OK button in the dialog box    

    Examples:
    | username | password |
    | TEST070823 | P@ss070823 |