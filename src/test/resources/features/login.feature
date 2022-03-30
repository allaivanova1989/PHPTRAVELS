Feature: Login on site
Scenario: Checking the ability to log in with valid data
  Given email for log in "ivanova.javaqa@gmail.com"
  Given password for log in "111222AAAiii"
  When User enters login and password and clicks Login button
  Then We can see text welcome