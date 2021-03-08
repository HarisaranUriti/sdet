Feature: HRMApp
   @HRMAct2
	  Scenario: Add information about a candidate for recruitment
	  Given User is on OrangeHRM webpage
	    Given User goes to the Recruitment page 
	    When User clicks on the Add button to add candidate information
	    Then User fills in the details of the candidate
	    And Upload a resume to the form
	    When User clicks the Save button
	    Then Navigate back to the Recruitments page to confirm candidate entry
	 #   And Close the browser 