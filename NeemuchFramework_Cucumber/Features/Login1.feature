Feature: Login functionality

  Scenario: Successful login with valid credentials and captcha
   Given User launches the Chrome browser
    When User opens the URL "https://vmedproqahealthandwellness.dhanushhealthcare.com/"
    When User enters the username "harilab@dhspltd.com"
    When User enters the password "654321"
    When User enters the captcha "1234"
    When User clicks the login button
    Then User should see the notification alert
    When User clicks on the profile icon
    Then User clicks on the Logout button
	
Scenario Outline: Login Data Driven 
	  Given User launches the Chrome browser
    When User opens the URL "https://vmedproqahealthandwellness.dhanushhealthcare.com/"
    When User enters the username "<email>"
    When User enters the password "<password>"
    When User enters the captcha "1234"
    When User clicks the login button
    Then User should see the notification alert
    When User clicks on the profile icon
    Then User clicks on the Logout button
	
	Examples: 
		| email                 | password  |
		| haritest@dhspltd.com  |	654321    |
		| harilab@dhspltd.com   | 654321	|