Feature: Verify shopify Search functionalities
	
@regression @healthCheck
  Scenario Outline: Verify Search functionalty should be working for correct search
  A valid Search option provided in search field should show results for related items
  
    Given I navigate to website and launch home page
    When I search for <searchParam>

   Examples:
    |searchParam		|
    |caserol				|
    |bottles				|

@regression @healthCheck
  Scenario Outline: Verify Search functionalty for invalid search
  Provide incorrect item name should display error message
  
    Given I navigate to website and launch home page
    When I search for <searchParam> and click to open Item page
			
   Examples:
    |searchParam		|
    |the err				|
    
