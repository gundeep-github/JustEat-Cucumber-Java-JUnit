Feature: Use the website - http://www.just-eat.co.uk/ to find restaurants
   		 So that I can order food
         As a hungry customer
         I want to be able to find restaurants in my area
          
	Scenario Outline: Search for restaurants in an area
   	  	Given I want food in "<postalCode>"
        When I search for restaurants
        Then I should see some restaurants in "<postalCode>"
        
 		Examples:
 		
  	|postalCode|
  	|AR51 1AA|
  	|PO16 7GZ|