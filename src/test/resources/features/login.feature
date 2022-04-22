Feature: Login on site

  Scenario: Checking the ability to log in with valid data
    Given email for log in "baby20086@rambler.ru"
    Given password for log in "123456789"
    When User enters login and password and clicks Login button
    Then We can see text welcome
    And HomePage is opened

  Scenario: Checking the ability to log in with invalid email
    Given email for log in "baby20086@rambler"
    Given password for log in "123456789"
    When User enters login and password and clicks Login button
    Then We had error message
    And We are on page failed

  Scenario: Checking the ability to log in with invalid password
    Given email for log in "baby20086@rambler.ru"
    Given password for log in "12345"
    When User enters login and password and clicks Login button
    Then We had error message
    And We are on page failed