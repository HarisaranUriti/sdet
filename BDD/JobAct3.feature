Feature: Jobboardapp
@JobAct3
Scenario Outline: Post a job using details passed
    Given Open browser with ​Alchemy Jobs site
    And Go to Post a Job page
    When User enters Job title as "<JobTitle>"
    Then Type in Description as "<Description>"
    And Enter Application email as "<Application>" and company as "<Company>" 
    Then Click submit
    And View listing in Alchemy Jobs for "<JobTitle>"
    
   Examples: 
      | JobTitle 		| Description 	   | Application   	 | Company  |
      |FullstackTester31  	| Description1     | tech@gmail.com      |	IBM |
    	|FullStackTesters41 	| Jobdescription1  | test@gmail.com      |	IBM |