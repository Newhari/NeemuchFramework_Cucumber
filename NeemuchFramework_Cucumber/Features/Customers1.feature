Feature: Add Patient Registration

 Background: In below are few steps Common in all Scenario 
    Given User launches the Chrome browser
    When User opens the URL "https://vmedproqahealthandwellness.dhanushhealthcare.com/"
    And User enters the username "harilab@dhspltd.com"
    And User enters the password "654321"
    And User enters the captcha "1234"
    And User clicks the login button
    When User clicks on the Lab Patient List

@sanity
Scenario: Add newPatient-Lab module
    And User clicks on the Add button
    When User enters the patient information
    And User clicks on the Submit button
   
@regression
Scenario: Search patient and perform Lab module actions
    When User enters the patient name in the search text field
    And User clicks on the Search button
    And User clicks on the Add Services button
    And User opens the Laboratory module
    And User opens the Lab Sample Collection section
    And User clicks on the Sample Collection option
    And User clicks on the Save Sample button
    And User clicks on the Approve Sample button
    And User opens the Test Result Entry screen
	
		
	