Feature: This contains multiple features of the dashboard

  @login
  Scenario Outline: Login with valid credentials
    Given user is in login page
    When user provides username  as "<uname>" and password as "<pass>"
    Then user should be able to login

    Examples:
    |uname|pass|
    |prema.eddyam+auto1@maestrano.com|Password1!|
    |prema.eddyam+auto1@maestrano.com|Password1|


    @addDashboard
    Scenario: Add dashboard
      Given user is in login page
      When user enters the credential for tester
      Then user should be able to login
      When user wants add a dashboard with name as "TestDashboard"
      Then user should on given dashboard


  @addModule @addModuleInNewDashboard
  Scenario: Add Module to an new dashboard
    Given user is in login page
    When user enters the credential for tester
    Then user should be able to login
    When user wants add a dashboard with name as "TestDashboard"
    Then user should on given dashboard
    When user edits the dashboard
    And user click on addmodule button
    And user add module with name as "Cash flow"
    And click on save
    Then added module should be displayed

@addKPI
  Scenario: Add KPI to the Business metric
    Given user is in login page
    When user enters the credential for tester
    Then user should be able to login

    When user edits the dashboard
    And add the kpi as "Gross profit"
    And add the time period as "Year to date"
    And add the comparision period as "vs. 3 months ago"
    And click on save