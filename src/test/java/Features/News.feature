Feature: Operations with news

  Scenario: Add a new news
    Given I am successfully logged in admin panel
    Then I am on the Admin page on URL "https://someURL"
    Given I am on news page in admin panel
    When I click on Add new news button
    And I fill in NAZVA field with random value
    And I fill in ZAGOLOVOK field with random unique value
    And I fill in SHORT TEXT field with "shla masha po shosse i sosala sushku"
    And I choose a news type "Новина"
    And I click on Submit button
    And I click on Success button
    Then I am on news page in admin panel
    Then I see a new news item in the news table

  Scenario: Delete a news item
    Given I am successfully logged in admin panel
    Then I am on the Admin page on URL "https://someURL/admin/applications"
    Given I am on news page in admin panel
    When I click on the first news item in the news list
    And I click on delete icon
    And I click on confirmation button
    And I click on Success button
    Then I am on news page in admin panel
    And I don't see selected news item any more
