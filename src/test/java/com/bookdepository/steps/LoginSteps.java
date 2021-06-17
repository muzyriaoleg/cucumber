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

    @Given("the user opens account page")
    public void userOpenAccountPage(){
        accountPage.open();
    }

    @When("the user types {string} in userEmail input")
    public void userTypeUserEmail(String userEmail) {
        accountPage.typeUserEmail(userEmail);
    }

    @And("the user types {string} in password input")
    public void userTypePassword(String password) {
        accountPage.typePassword(password);
    }

    @And("the user press Sign in button")
    public void userPressSignINButton(){
        accountPage.signIn();
    }

    @Then("My Account button appears")
    public void myAccountButtonAppears() {
        Assertions.assertThat(accountPage.isMyAccountButtonPresent());
    }
}
