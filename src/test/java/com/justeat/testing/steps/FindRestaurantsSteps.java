package com.justeat.testing.steps;

import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.JustEatHomePage;
import pages.RestaurantsListingPage;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FindRestaurantsSteps {

	private JustEatHomePage justEatHomePage;
	private RestaurantsListingPage restaurantsListingPage;

	public FindRestaurantsSteps() {
		justEatHomePage = new JustEatHomePage();
		restaurantsListingPage = new RestaurantsListingPage();
	}

	@Given("^I want food in \"([^\"]*)\"$")
	public void userLaunchesWebsiteAndEntersPostalCode(String postalCode) {
		justEatHomePage.goToHomePage();
		justEatHomePage.searchFor(postalCode);
	}

	@When("I search for restaurants")
	public void userSearchForRestaurants() {
		justEatHomePage.search();
	}

	@Then("^I should see some restaurants in \"([^\"]*)\"$")
	public void resultDisplaysRestaurantSearchedFor(String postalCode) throws InterruptedException {
		Assert.assertEquals(postalCode, restaurantsListingPage.getPostalCode());
		restaurantsListingPage.navigateToRestaurantDetailsPageAndVerifyPostalCode(postalCode);
	}
}
