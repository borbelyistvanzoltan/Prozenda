Narrative:
Travel Ledger 3rd automation test

Scenario: TL-141 Bookings Review - Booking edit - status - single record - rejection
Given user is on Login page
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Change dropdown and select Buyer - All Due
Then Filter for "ER1234146" booking reference
Then Check that transaction status dropdown has proper elements for "ER1234146"
Then Click on the "ER1234146" transaction status which has blank status and select REJECTED status
