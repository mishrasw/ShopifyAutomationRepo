Feature: Verify shopify website functionalities
	
@regression @healthCheck
  Scenario Outline: Verify Search functionalty
    Given I navigate to website and launch home page
    When I search for <searchParam>

   Examples:
    |searchParam		|
    |caserol				|
    |bottles				|
    
