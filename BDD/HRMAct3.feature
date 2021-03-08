Feature: HRMApp adding mutpl emp
  @HRMAct3
	  Scenario Outline: Add multiple employees using the Examples table
	    Given User navigates to the PIM option in the menu and click it
	    When Click the Add button to add a new Employee
	    Then Make sure the Create Login Details checkbox is checked
	    And Fill in the "<FirstName>", "<LastName>", "<EmployeeID>", and "<UserName>"
	    When User clicks the Save button
	    Then Verify that the employee "<FirstName>", "<LastName>" has been created
	    #And Close the browser  
	

	    Examples: 
	      | FirstName     | LastName  	| EmployeeID  |	UserName  |
	      | Sree          | ln          | 00001			  |	sree12 	|
	      | Sree1         | ln1         | 00002		          |	sree13	|