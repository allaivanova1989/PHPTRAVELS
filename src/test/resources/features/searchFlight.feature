Feature:checking flights

  Scenario: Check specific flight
    Given User on the flightsPage
    When User look for flights company "Turkish Airlines"
    Then Airline was found