Feature: Operations with petitions

  Scenario: Add a new petition
    Given I am successfully logged in admin panel
    Then I am on the Admin page on URL "https://someURL/admin/applications"
    Given I am on petition page in admin panel
    When I click on Add new petition button
    And I fill in user name as "pupkin"
    And I click on Viznachiti Zayavnika button
    And I fill in petition zagolovok with randomly generated one
    And I set a petetion category to "Транспорт"
    And I fill in petition text as "lorem ipsum est dolor deus vult"
    And I click on STVORITI button
    And I click on Success button
    Then I am on petition page in admin panel
    And I see an added petition in the petition list

