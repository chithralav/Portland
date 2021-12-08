@tag1
Feature: Feature to test Favorites functionality

  Scenario: User sign up to the website "qa-task.backbasecloud.com"
  Given User should be authenticated to the website
  And User should be signed up for the website
  When the user sign in
  Then Your feed page is displayed
  
  Scenario: To test Favorite button presence on all the articles on the page
    Given The user is signed in to the website with username and password
    When the user is on the Global feed page
    Then Favorite should be displayed on all the articles on the page

    Scenario: To test Favorite button increments on clicking
    Given The user is signed in to the website and is on Global page
    When the user clicks the Favorite button on the article preview
    Then Favorite button value should be incremented by one
    
    Scenario: To test Favorite button icremented vale is retained
    Given  user is signed in to the website and is on Global page
    When user clicks the Favorite button on the article preview
   And the user clicks on Global feed to refresh the page
    Then Favorite button incremented value should be retained
    
    Scenario: To test Favorite button mousehover action
    Given user is signed in to the website 
    When the user is on the Global feed page and hovers over favorite button
   Then Favorite button background color changes
   
   Scenario: To test Favorite button text after click in article page
    Given user is signed in to the website and is on article page
    When the user clicks on Favorite button
    Then Favorite button text chnages to unfavorite article