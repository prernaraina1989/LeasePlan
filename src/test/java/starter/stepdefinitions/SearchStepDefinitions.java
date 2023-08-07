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
	public ProductsAPI productsAPI;

	@When("he calls endpoint {string}")
	public void he_calls_endpoint(String string) {
		SerenityRest.given().get(string);
	}

	@Then("status code of endpoint is {string}")
	public void status_code_of_endpoint(String status) {
		restAssuredThat(response -> response.statusCode(Integer.parseInt(status)));
	}

	@Then("he sees the results displayed for {string}")
	public void he_sees_the_results_displayed_for_product(String product) {
		if (product.equalsIgnoreCase("apple")) {
			restAssuredThat(response -> response.statusCode(200));
		} else
			restAssuredThat(response -> response.body("title", contains("mango")));
	}

	@Then("he sees the error code")
	public void he_sees_the_error_code() {
		restAssuredThat(response -> response.statusCode(404));
	}

	@Then("he does not see the results")
	public void he_does_not_see_the_results() {
		restAssuredThat(response -> response.body("detail.error", equalTo(true)));
	}
}
