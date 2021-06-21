Feature: As a customer I would like to buy tickets in comfort class for 3 passengers from "Lagos" to "Porto - Campanha"

  Scenario: Buy Tickets from "Lagos" to "Porto - Campanha" in comfort class for 3 passengers
    Given I open cp.pt website
    And I open Buy Tickets page
    And I can see Online Tickets form
    And I search for a train from "Lagos" to "Porto - Campanha"
    And I choose to start the trip Lagos > Porto-Campanha in 3 days
    And I choose to return in 3 days from Porto-Campanha > Lagos after the start of the trip
    And I choose comfort class for passengers
    And I choose 3 passengers for the trip
    And I click on Submit button
    And I can see Online Tickets Office service
    And I choose the 1 service in the outward list
    And I choose the 1 service in the inward list
    And I click on the checkbox that I declare that I have read and accepted
    And I click on Continue button
    And I see authorization form to continue with the purchase
    When I click on Cancel button
    Then I can see Online Tickets form
    And I check that in Buy Tickets form's fields have remained data from last time




