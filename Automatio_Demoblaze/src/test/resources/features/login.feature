Feature: feature to test login functionality 

	Background: User in home page
	  Given browser is open
    And user is on home page
    And user set delay 5 seconds

	@PositiveTestCase
  Scenario Outline: Test login function
    When user click login button
    And user set delay 5 seconds
    Then verified login form
    When user inputs <username1> and <password2>
    And user set delay 5 seconds
    And user clicks on signup button
    And user set delay 5 seconds
    When dialog box is displayed
    Then user clicks the OK button in the dialog box    

    Examples:
    | username | password |
    | TEST070823 | P@ss070823 |