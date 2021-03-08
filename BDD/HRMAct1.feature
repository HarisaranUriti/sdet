Feature: HRM Scenarios
	  @HRMAct1
	  Scenario: To create a job vacancy for “DevOps Engineer”
	    Given User is on OrangeHRM page and logs in
	    Given User navigates to the Recruitment page
	    When User clicks on the Vacancies menu item to navigate to the vacancies page
	    Then Click on the Add button to navigate to the Add Job Vacancy form
	    And Fill out the details like "DevOps Engineer", "Engineer vacancies32", "orange hrm", "3"
	    When User clicks the Save button
	    Then Verify that the vacancy was created for "DevOps Engineer"
	 #   And Close the browser