package com.bookdepository.steps;

import com.bookdepository.pages.desktop.PageFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;


public class LoginSteps extends PageFactory {


    @Given("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) open(?:s)? (.+)$")
    public void userOpenPage(String pageName) {
        createPage(pageName).open();
    }

    @When("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in userEmail (?:input|field)$")
    public void userTypeUserEmail(String userEmail) {
        getAccountPage().switchToIframe(0);
        getAccountPage().emailInput.typeText(userEmail);
    }

    @And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in password (?:input|field)$")
    public void userTypePassword(String password) {
        getAccountPage().passwordInput.typeText(password);
    }

    @And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:press|click) Sign in button$")
    public void userPressSignINButton() {
        getAccountPage().signInButton.press();
    }

    @Then("My Account button (?:is |)(?:appear(?:s)?|visible|clickable)$")
    public void myAccountButtonAppears() {
        Assertions.assertThat(getAccountPage().myAccountButton.get().isDisplayed())
                .as("Account button is not present").isTrue();
    }
}
