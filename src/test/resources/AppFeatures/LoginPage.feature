Feature: Login Feature



  Scenario: login with correct credential
    Given User is on Para Bank home Page
    Then Page title should be "ParaBank | Welcome | Online Banking"
    When Cusotmer Login section is present
    And user enter "rohitr357" and "Rohit@1999"
    And click on login button
    Then User should navigated to Home Page
    
  Scenario Outline: Login with incorrect credential
  	Given User is on Para Bank home Page
  	Then Page title should be "ParaBank | Welcome | Online Banking"
    When Cusotmer Login section is present
    And user enter "abcd" and "abc@123"
    And click on login button
    Then User should not get navigated to Home Page
    
    #Examples: |user name | password  |
    #					|abcd|abc@123|
    #					|p23|p23@123|
    #					

					
					
					