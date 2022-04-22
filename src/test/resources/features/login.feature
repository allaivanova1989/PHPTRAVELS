Feature: Login on site

  Scenario: Checking the ability to log in with valid data
    Given email for log in "allaivanova.javaqa@mail.ru"
    Given password for log in "12345darina"
    When User enters login and password and clicks Login button
    Then We can see text welcome

  Scenario: Checking the ability to log in with invalid email
    Given email for log in "allaivanova.javaqa@mail"
    Given password for log in "12345darina"
    When User enters login and password and clicks Login button
    Then We had error message
