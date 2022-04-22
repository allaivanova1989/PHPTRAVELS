Feature: SignUp

  Scenario Outline: Checking the ability to register on the site
    Given firstName for log in <firstName>
    Given lastName for log in <lastName>
    Given phone for log in <phone>
    Given email for log in <email>
    Given password for log in <password>
    Given accountType for log in <accountType>
    When Input all data in the fields and click on button SignUp
    Then registration completed successfully

    Examples:
      | firstName  | lastName  | phone           | email                    | password   | accountType |
      | "Alla"     | "Ivanova" | "+37529867833"  | "ivanova.java@gmail.com" | "dfghjk"   | "Customer"  |
      | "Marta"    | "Petrova" | "+375336523636" | "ivanov@gmail.com"       | "84562165" | "Agent"     |
      | "Victorya" | "Michno"  | "+3852698755"   | "ivanova.java@mail.ru"   | "cfgh5"    | "Supplier"  |

