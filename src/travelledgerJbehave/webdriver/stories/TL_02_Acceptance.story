Narrative:
Travel Ledger 2nd automation test

Scenario: Bookings Review - Booking edit - status - single record acceptancee
Given user is on Login page
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Change dropdown and select Buyer - All Due
Then Filter for "ER1234189" booking reference
Then Check that transaction status dropdown has proper elements for "ER1234189"
Then Click on the "ER1234189" transaction status which has blank status and select ACCEPTED status