@activity
Feature: Creating new user

  @JobAct1
  Scenario: Visit the site backend and create a new user
    Given open a webpage
    When user logged in and lands on webpage
    And trying to add new user and filling necessary details
    Then user was created and verify
    And shut the browser