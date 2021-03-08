Feature: Create leads using parameterization
  @CRMAct2
  Scenario Outline:  add multiple lead accounts
    Given open a broswer and login into alchemy CRM webpage
    When user logged in and creating a lead
    And user adds details like "<lastname>" and saving
    Then check the results for added leads
    And closing browser

    Examples: 
      | lastname|
      | Test1   | 
      | Test2   |    
