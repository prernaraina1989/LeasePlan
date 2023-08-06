Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios
 
 
  #Scenario:
   # When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/orange"
   # Then he sees the results displayed for apple
   # When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/apple"
   # Then he sees the results displayed for mango
   # When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/car"
   # Then he doesn not see the results
  

#Scenario1 - Positive Scenario - Given/Update
Scenario: 
   When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/orange"
   Then he sees the results displayed for "apple"

#Scenario2 - Positive Scenario - Added
Scenario:   
   When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/mango"
   Then he sees the error code
   
#Scenario3 - Negative Scenario - Added
Scenario: 
    When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/pasta"
    Then status code of endpoint is "200" 
    
#Scenario4 - Negative Scenario - Given/updated
Scenario: 
		When he calls endpoint "https://waarkoop-server.herokuapp.com/api/v1/search/demo/mango"
    Then status code of endpoint is "404"
    And he doesn not see the results

    


