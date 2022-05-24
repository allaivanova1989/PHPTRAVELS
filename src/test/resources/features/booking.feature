Feature: Booking hotels

  Scenario: Checking the ability to book hotel with real date and real city
    Given User on the Homepage
    When User enters cityName "Berlin" for booking
    And User chooses real arrivalDate for booking
    And User chooses real departureDate for booking
    And User chooses travellers and rooms
    And User click on search button
    Then Searching is failed

  Scenario: Checking the impossibility of choosing a date earlier than the current one
    Given User on the Homepage
    When User enters cityName "Berlin" for booking
    And User chooses past arrivalDate for booking
    Then PastDate is not selected

