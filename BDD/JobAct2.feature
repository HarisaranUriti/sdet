Feature: JobBoardApp

  @JobAct2
  Scenario: Searching for jobs and applying to them 
    Given open alchemy jobs webpage and navigate to jobs page
    And finding keywords in search input field
    Then search for jobs changing the job type and searching for fulltime job
    Then finding title of the job and to print it
    And applying for a job and closing browser