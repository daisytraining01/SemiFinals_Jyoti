Feature: Register in Techfish bank

@demo
Scenario: Add recipient
Given login with credentials
Then clicks add recipient
When user enters the details
Then new recipient is added

