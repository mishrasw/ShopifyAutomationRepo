Feature: Verify shopify website Add To Cart related functionalities
	
@regression
  Scenario Outline: Verify Add to Cart is working for a perticular item
  Test different type of products added to Add To Cart successfully
  
    Given I navigate to website and launch home page
    When Search input <searchParam> and click to open Item page

   Examples:
    |searchParam																															|
    |Stainless Steel Casserole Blue 3500ml																		|
    |Stainless Steel Casserole Blue 2500ml																		|
		|Microwave Safe Stainless Steel Lunch Box With Bag (2 Containers)					|
