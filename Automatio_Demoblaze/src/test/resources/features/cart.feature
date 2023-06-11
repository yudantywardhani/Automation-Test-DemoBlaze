Feature: feature to test cart functionality

	@PositiveTestCase
  Scenario Outline: Test place order success
    #openBrowser
    Given browser is open
    And user is on home page
    And user set delay 5 seconds
    #addLaptopProcess
    And user clicks Laptops category
    And user set delay 5 seconds
    And user scroll down
    And user set delay 5 seconds
    When user clicks MacBook Pro
    And user set delay 5 seconds
    Then verified product details
    And user set delay 5 seconds
    And user clicks Add to Chart button
    And user set delay 5 seconds
    When dialog box is displayed 
    Then verified product added
    And user set delay 5 seconds
    #addMonitorProcess
    And user clicks Home button 
    And user set delay 5 seconds
    And user clicks Monitor category
    And user set delay 5 seconds
    When user clicks Apple Monitor
    And user set delay 5 seconds
    Then verified product details
    And user set delay 5 seconds
    And user clicks Add to Chart button
    And user set delay 5 seconds
    When dialog box is displayed
    Then verified product added
    And user set delay 5 seconds
    #goToTheCart
    When user clicks cart button
    And user set delay 5 seconds
    Then verified cart page
    And user set delay 5 seconds
    And user clicks delete button 
    And user set delay 5 seconds
    #placeOrderProcess
    And user clicks place order button
    And user set delay 5 seconds
    And user inputs <name> <country> <city> <creditcard> <month> and <year> po
    And user set delay 5 seconds
    When user clicks purchase button
    And user set delay 5 seconds
    Then purchase successful
    And close browser

    Examples: 
      | name   | country   | city    | creditcard | month | year |
      | dadang | indonesia | jakarta |      12345 | juni  | 2023 |
