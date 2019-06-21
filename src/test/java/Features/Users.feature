Feature: Operations with users

    Scenario: Add a new user
      Given I am successfully logged in admin panel
      Then I am on the Admin page on URL "https://someURL/admin/applications"
      Given I am on users page in admin panel
      And I checked what is the INN that is not used
      When I click on Add new user button
      And I fill in INN field random INN number
      And I fill in Last name field with "Pupkin"
      And I fill in Name field with "Vasya"
      And I fill in Passport field with "AA000777"
      And I add passport photo
      And I add inn photo
      And I add photo with passport
      And I fill Address field
      And I fill in Login field with random login
      And I fill in Password field with "password"
      And I click a button Zberegti
      And I click a Success button
      Then I see a created User in a Users table

    Scenario: Add user with existing INN
      Given I am successfully logged in admin panel
      Then I am on the Admin page on URL "https://someURL/admin/applications"
      Given I am on users page in admin panel
      When I click on Add new user button
      And I fill in INN field with "0000000000" value
      And I fill in Last name field with "Pupkin"
      And I fill in Name field with "Vasya"
      And I fill in Passport field with "AA000777"
      And I add passport photo
      And I add inn photo
      And I add photo with passport
      And I fill Address field
      And I fill in Login field with random login
      And I fill in Password field with "password"
      And I click a button Zberegti
      Then I see an error popup

    Scenario: Change user data
      Given I am successfully logged in admin panel
      Then I am on the Admin page on URL "https://someURL/admin/applications"
      Given I am on users page in admin panel
      When I Edit a user
      And I change Last name field to a random value
      And I change First name field to a random value
      And I change address to a random value
      And I click a button Zberegti
      And I click a Success button
      Then I see a user with new FirstName and LastName
      And I see a user with new City, Street and Building

