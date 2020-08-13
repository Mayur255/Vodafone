@tag
Feature: Title of your feature


  
  @tag2
  Scenario Outline: Title of your scenario outline
  
    Given Opne Bill Pay page
    When Enter Mobile number <number>
   # Then I check for the <amount> in step
    #Then Click Pay button
    Then Select Wallet >> Click Pay button for Paytm >> Paytm page should display1

    Examples: 
      | number     | amount |
      | 9921177701 |     5 	|
      | 9921177701 |     7 	|
      | 9921177701 |     11	|
      | 9921177701 |     12	|
      | 9921177701 |     15	|
