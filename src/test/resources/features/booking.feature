Feature: Booking hotels

  Scenario Outline: Checking the ability to book hotel
    Given cityName for booking <cityName>
    Given checkingDate <dateOne>
    Given checkoutDate <dateTwo>
    Given travellersRoom <roomNumber>
    When We input data and search hotels
    Then We can see text welcome


    Examples:
      | cityName | dateOne    | dateTwo    | roomNumber |
      | London   | 25-08-2022 | 26-08-2022 | 1          |
      | Berlin   | 12-06-2022 | 17-06-2022 | 2          |
      | Minsk    | 01-07-2022 | 18-07-2022 | 1          |