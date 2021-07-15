Feature: Menu and submenu
  As a user I should be able to choose menu and options
  @menu
  Scenario Outline: Validate menu and subMenu feature
    Given I am on home page
    When I choose menu option "<Menu>"
    When I choose subMenu options "<Submenu>"
    Then I should be redirected to appropriate search page "<resultHeader>"
    Examples:
    |Menu |Submenu|resultHeader|
    |MEN  |Jeans  |Men's Jeans |
    |WOMEN|Curve  |Women's Curve Clothing|
    |SPORTS|Golf  |Golf                  |

