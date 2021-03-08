Feature: CRMApp

  @CRMAct3Meeting
  Scenario Outline: Schedule a meeting and invite members
	    Given User navigates to Activities, Meetings, and Schedule a meeting
	    When User gives details
	    And User searches and add members
	    |	firstName |	lastName	  |	email						        |
	    |	one		    |	one	        | one.one@example.com		  |
	    |	two     	|	two		      |	two.hr@example.net      |
	  #  |	three 		|	three		   	|	three.info@example.tv	  |
	    Then Navigate to View Meetings page and confirm creation of the meeting
	  #  And Close the browser