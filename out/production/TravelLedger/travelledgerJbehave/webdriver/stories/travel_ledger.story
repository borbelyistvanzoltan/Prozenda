Narrative:
Travel Ledger automation tests

Scenario: login as Seller, import Transaction file, validate the upload, login as Buyer, validate Transaction file
Given user is on Login page
Given I login as: "istvan.borbely@prozenda.com" with password: "Prozenda2022"
Given Wait for loading main page
Then Navigate to Import file page
Then Select Auto commit uploaded invoices checkbox
!-- Then Upload transaction file from "\\/Users\\/borbelyistvan\\/Documents\\/Prozenda\\/Travelledger\\/transactions.xls"
Then Navigate to Bookings page
Then Check that the transactions have been commited and can be viewed
Then Logout
Given I login as: "borbely.istvan.zoltan@gmail.com" with password: "Prozenda2022"
Then Navigate to Bookings page
Then Check that the transactions have been commited and can be viewed