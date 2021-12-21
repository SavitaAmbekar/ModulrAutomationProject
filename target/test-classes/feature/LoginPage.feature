Feature: As a user I should be able to login with valid credentials

  Scenario Outline: Login into the application with valid credentials
  	Given I am on the Login page URL "Modulr Payments"
    When I enter username as "<username>"
    And I enter password as "<password>"
    And click on login button
    Then I am able to see "<message>"
    
    Examples:  
    |username|password|message|
    |        |        | This field is required |
    |Savita.Adhal86|dec|The username or password is incorrect|
    |dec|February@2021|The username or password is incorrect|
  
    
  Scenario: Login into the application with valid credentials
  	Given I am on the Login page URL "Modulr Payments"
    When I enter username as "Savita.Adhal86"
    And I enter password as "February@2021"
    Then I click on "login" button
    And I am able to see "Modulr Payments"
    
  Scenario: user should able to reset password.
    Given I am on the Login page URL "Modulr Payments"
	  Then I click on "Forgot Password" button
		And I enter reset username as "Savita.Adhal86"
		Then I click on "Request a Reset" button
		And I am able to see "Email sent"
    
