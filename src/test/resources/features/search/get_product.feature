Feature: Get Product
	
	Scenario: Positive Scenario - Get Product Orange
  	When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/orange"
   	Then he sees the results displayed for "apple"

	Scenario:  Positive Scenario - Get Product Mango 
  	When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/mango"
   	Then he sees the error code
    
	Scenario: Negative Scenario - Get Product Pasta
        When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/pasta"
        Then status code of endpoint is "200" 
    
	Scenario: Negative Scenario - Get Product Mango
        When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/mango"
        Then status code of endpoint is "404"
        And he does not see the results

    


