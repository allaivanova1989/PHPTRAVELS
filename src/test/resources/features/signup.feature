Feature: SignUp

#  Scenario Outline: Checking the ability to register on the site with different data
#    Given User on the signup page
#    When user enters firstName  <FirstName>
#    And user enters lastName <LastName>
#    And user enters phone <Phone>
#    And user enters email <Email>
#    And user enters password <Password> and click on signup
#    And User click on Signup
#    Then registration is successful
#    Examples:
#      | FirstName  | LastName  | Phone           | Email                       | Password   |
#      | "Alla"     | "Ivanova" | "+37529867833"  | "iahknohjva.java@gmail.com" | "dfghjk"   |
#      | "Marta"    | "Petrova" | "+375336523636" | "iafvgnov@gmail.com"        | "84562165" |
#      | "Victorya" | "Michno"  | "+3852698755"   | "ivanova.java@mail.ru"      | "cfgh5"    |


  Scenario: Checking the ability to register on the site with different data(table)
    Given User on the signup page
    When user enters data in fields and click on SignUp
      | Fields    | Value         |
      | FirstName | Alla           |
      | LastName  | Ivanova        |
      | Phone     | +375263689     |
      | Email     | hbjhkl@mail.ru |
      | Password  | sedfghjk       |




    Then registration is successful
