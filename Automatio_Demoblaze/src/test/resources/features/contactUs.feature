Feature: feature to test contact us functionality

  @PositiveTestCase
  Scenario Outline: Test signup function sucess
    Given browser is open
    And user is on home page
    And user set delay 5 seconds
    When user click contact us button
    And user set delay 5 seconds
    Then verified new message form
    And user set delay 5 seconds
    When user inputs <email> and <name> and <message> contact
    And user set delay 5 seconds
    And user clicks send message button
    And user set delay 5 seconds
    When dialog box is displayed
    Then verified send message sucessful
    And close browser

    Examples: 
      | email         | name     | message                |
      | test@mail.com | TestNama | TestMessageTestMessage |
