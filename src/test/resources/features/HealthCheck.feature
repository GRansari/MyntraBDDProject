@ui

Feature: E-commerce Project Web Site Health Check

@a
Scenario: user is able to open the application and able to perform a search opration for gift
#Given User open the browser
And User Navigated to the landing page of the application
When User search for the product "Wallet"
Then search result is displayed "Wallet"

@b
Scenario: User is click on the Product and check the Product Details
#Given User open the browser
And User Navigated to the landing page of the application
When User search for the product "plazo"
And  User click on any product
Then Product Description is displayed in new tab

@MultiSearch
  Scenario Outline: User is able to search multiple products
    When User Navigated to the landing page of the application
    And User Search for product "<product_name>"
    Then Search Result page is displayed as "<prod_result>"
    Examples: 
      | product_name | prod_result |
      | Kurti        | Kurti       |
      | Palazzo Pants| Palazzo Pants |
      | Top          | Top         |