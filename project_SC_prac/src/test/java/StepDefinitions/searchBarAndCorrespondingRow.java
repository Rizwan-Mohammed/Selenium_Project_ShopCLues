package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchBarAndCorrespondingRow {
	@Given("when the user is on the homepage of shopclues")
	public void when_the_user_is_on_the_homepage_of_shopclues() {
	    
	    System.out.println("this code is in given statement");
	}

	@When("the user clicks in search bar and enter the text")
	public void the_user_clicks_in_search_bar_and_enter_the_text() {
		System.out.println("this is is when statement");						
	}

	@And("user click on search button")
	public void user_click_on_search_button() {
		System.out.println("this is is And statement");
	}

	@Then("the user is presented with list options")
	public void the_user_is_presented_with_list_options() {
		System.out.println("this is is Then statement");
	}
}
