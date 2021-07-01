package com.bookdepository.steps;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.pages.desktop.pages.AccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class LoginSteps {

    private AccountPage accountPage = new AccountPage(DriverManager.getChromedDriverInstance());

    @Given("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) open(?:s)? account page$")
    public void userOpenAccountPage(){
        accountPage.open();
    }

    @When("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in userEmail (?:input|field)$")
    public void userTypeUserEmail(String userEmail) {
        accountPage.typeUserEmail(userEmail);
    }

    @And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:type|enter)(?:s)? (.+) in password (?:input|field)$")
    public void userTypePassword(String password) {
        accountPage.typePassword(password);
    }

    @And("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) (?:press|click) Sign in button$")
    public void userPressSignINButton(){
        accountPage.signIn();
    }

    @Then("My Account button (?:is |)(?:appear(?:s)?|visible|clickable)$")
    public void myAccountButtonAppears() {
        Assertions.assertThat(accountPage.isMyAccountButtonPresent());
    }
}
