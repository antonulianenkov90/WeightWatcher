Feature: Studio Search

Scenario: Find nearest studio for zip code

Given User on home page
When Click on find a studio
And In the search field, search for meetings for zip code "10011"
And Click on the first search result
Then Displayed location name matches with the name of the first searched result



