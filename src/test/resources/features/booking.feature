Feature: Booking hotels

  Scenario Outline: Checking the ability to book hotel
    Given User on the start page
    When User enters cityName <CityName> for booking
    And User enters arrivalDate <ArrivalDate> for booking
    And User enters departuredate <DepartureDate> for booking
    And User chooses travellers and rooms
    And User click on searche button
    Then Searching is failed


    Examples:
      | CityName | ArrivalDate  | DepartureDate |
      | "London" | "25-08-2022" | "26-08-2022"  |
      | "Berlin" | "12-06-2022" | "17-06-2022"  |
      | "Minsk"  | "01-07-2022" | "18-07-2022"  |