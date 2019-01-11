Feature: Register

  @facebook
  Scenario Outline: Register a user
    Given user launches the facebook
    When user enters signup information "<FirstName>","<LastName>","<Email>","<Mobile>"
    And user clears sign up information
    Then sign up info is cleared

    Examples:
      | FirstName | LastName | Email               | Mobile   |
      | Mehraj    | Shaik    | mehraj999@gmail.com | 92379889 |
      | Mehraj    | Pasha    | mehraj999@gmail.com | 92379889 |