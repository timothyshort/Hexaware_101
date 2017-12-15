Feature: The SDET Training AMS Application
	As a user, account holder of the AMS application
	I want to, login to the application
	So that, I can view my account information
	
#Define Scenario: a specific instance or situation of the feature
#Scenarios use a Given-When-Then structure / outline
Scenario: the user should be able to login and view their balance
	Given the user is on the AMS page
	When the user enters correct username and password
	#Then the user should be able to view their balance
	Then the user should be able to update their subscription
	And the user should be able to change their password
	And the user should be able to cancel their account
	
Scenario: the user should receive a notification of a failed login
	Given the user is on the AMS page
	When the user enters bad username
	And the user enters bad password
	And the user clicks login button
	Then the user should not be able to log in
	And the user receives a invalid login message