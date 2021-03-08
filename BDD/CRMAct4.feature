Feature: Creating a Product

 @CRMAct4      
	  Scenario Outline: To use an Examples table to add products
	    Given User navigates to All, Products, and Create Product
	    And User enters details about the product like "<Name>" and "<Price>"
	  #  When User clicks Save button
	    Then User navigates to View Products page to see "<Name>" listed
	  #  And Close the browser
	

	    Examples: 
	      | Name		  | Price |
	      | Table     	| 1000    |
	      | Table1 	 	| 1435 |