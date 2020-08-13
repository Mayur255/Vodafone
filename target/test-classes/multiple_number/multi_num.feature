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
      | 7769941028 |     5 	|
      | 7769941028 |     7 	|
      | 7769941028 |     11	|
      | 7769941028 |     12	|
      | 7769941028 |     15	|
