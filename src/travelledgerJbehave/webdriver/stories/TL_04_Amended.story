Narrative:
Travel Ledger automation tests

Scenario: TL-142 Booking edit - status - single record - amendment
Given user is on Login page
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Change dropdown and select Buyer - All Due
Then Filter for "ER1234161" booking reference
Then Check that transaction status dropdown has proper elements for "ER1234161"
Then Click on the "ER1234161" transaction status which has blank status and select AMENDED status