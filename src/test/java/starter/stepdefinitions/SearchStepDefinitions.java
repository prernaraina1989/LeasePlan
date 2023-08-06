package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class SearchStepDefinitions {


    @Steps
    public ProductsAPI carsAPI;

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String arg0) {
        SerenityRest.given().get(arg0);
    }

	@Then("status code of endpoint is {string}") 
	public void StatusCodeOfEndpoint(String status) { 
		restAssuredThat(response -> response.statusCode(Integer.parseInt(status))); 
	}
	 
    @Then("he sees the results displayed for {string}")
    public void heSeesTheResultsDisplayedForProduct(String product) {
    	if (product.equalsIgnoreCase("apple")){
    		restAssuredThat(response -> response.statusCode(200));
    	}
    	else restAssuredThat(response -> response.body("title", contains("mango")));      
    }

    @Then("he sees the error code")
    public void heSeesTheErrorCode() {
    	restAssuredThat(response -> response.statusCode(404));
    }
   
    @Then("he doesn not see the results")
    public void heDoesnNotSeeTheResults() {
        restAssuredThat(response -> response.body("detail.error", equalTo(true)));
    }   
}
