Feature: Ebay Home
  Scenario: Access a Product via category after applying multiple filters
    Given User redirect to "https://www.ebay.com/"
    And User navigate to Search by Category
    And User click on Cellphone & Accessories
    And User click on Cellphone & Smartphone
    When User Click on More Refinements
    And User select "Matrix" tags
    And User select "Metro" tags
    And User select "MTS" tags
    Then system show selected "Matrix" tags on result
    And system show selected "Metro" tags on result
    And system show selected "MTS" tags on result
    And system show "3" filters selected

  Scenario: Access a Product via Search
    Given User redirect to "https://www.ebay.com/"
    And User type "MacBook" on the search bar
    And User select Category "Computers/Tablets & Networking"
    When User click Search button
    Then system load result completely
    And system show first result matches "MacBook"
