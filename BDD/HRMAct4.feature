Feature: HRMApp
 @HRMAct4
	  Scenario Outline: Creating multiple vacancies using data from an Examples table
	    Given User navigates to the Recruitment page
	    When User clicks on the Vacancies menu item to navigate to the vacancies page
	    Then Click on the Add button to navigate to the Add Job Vacancy form
	    And Fill out the details like "<JobTitle>", "<VacancyName>", "<HiringManager>", "<Positions>"
	    When User clicks the Save button
	    Then Verify that the vacancy was created for "<JobTitle>"
	    #And Close the browser
	

	    Examples: 
	      | JobTitle  			   | VacancyName			  	| HiringManager  |	Positions	|
	      | Android Developer		   | A vacancy           			| hiremngr	 |	10		|
	      | Java Developer   		   | Developervacancy    			| hiremngr1	 |	10		|