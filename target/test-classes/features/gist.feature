Feature: As User creating a end-to-end (e2e) tests for creating a gist
  Scenario: As a user, I want to create a public gist
    Given User redirect to "https://gist.github.com/Gloriahtr"
    When User add new public gist
    Then displayed gist added

  Scenario: As a user, I want to edit an existing gist
    Given User redirect to "https://gist.github.com/Gloriahtr"
    When User  edit an existing gist
    Then displayed gist updated

  Scenario: As a user, I want to delete an existing gist
    Given User redirect to "https://gist.github.com/Gloriahtr"
    When user delete an existing gist
    Then displayed list all gist

  Scenario: As a user, I want to see my list of gists.
    Given User redirect to "https://gist.github.com/Gloriahtr"
    When user click see all of your gists
    Then displayed list all gist