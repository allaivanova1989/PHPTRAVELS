Feature: SignUp

  Scenario Outline: Checking the ability to register on the site with different data
    Given User on the signup page
    When user enters firstName  <FirstName>
    And user enters lastName <LastName>
    And user enters phone <Phone>
    And user enters email <Email>
    And user enters password <Password>
    And User click on Signup
    Then registration should be successful
    Examples:
      | FirstName  | LastName  | Phone           | Email                    | Password   |
      | "Alla"     | "Ivanova" | "+37529867833"  | "ivanova.java@gmail.com" | "dfghjk"    |
      | "Marta"    | "Petrova" | "+375336523636" | "ivanov@gmail.com"       | "84562165" |
      | "Victorya" | "Michno"  | "+3852698755"   | "ivanova.java@mail.ru"   | "cfgh5"    |