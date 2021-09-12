package com.bookdepository.spteps;

import org.assertj.core.api.Assertions;

import com.bookdepository.pages.desktop.PageFactory;

import io.cucumber.java.en.*;


public class LoginSteps extends PageFactory {


	@Given("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) open(?:s)? (.+)$")
	public void userOpenPage(String pageName) {
		createPage(pageName).open();
	}

	@When("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in userEmail (?:input|field)$")
	public void userTypeUserEmail(String userEmail) {
		getAccountPage().typeUserEmail(userEmail);
	}

	@And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in password (?:input|field)$")
	public void userTypePassword(String password) {
		getAccountPage().typePassword(password);
	}

	@And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:press|click) Sign in button$")
	public void userPressSignINButton() {
		getAccountPage().signIn();
	}

	@Then("My Account button (?:is |)(?:appear(?:s)?|visible|clickable)$")
	public void myAccountButtonAppears() {
		Assertions.assertThat(getAccountPage().isMyAccountButtonPresent()).as("Account button is not present").isTrue();
	}
}
