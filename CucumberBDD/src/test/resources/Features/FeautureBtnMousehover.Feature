
Feature: Feature to test Favorites functionality
    Scenario: To test Favorite button mousehover action
    Given The user is signed in to the website with username and password
    When the user is on the Global feed page and hovers over favorite button
   	Then Favorite button background color changes
