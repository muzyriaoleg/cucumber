package parallel;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.pages.desktop.PageFactory;

import io.cucumber.java.en.*;


public class LoginStepsParallel extends PageFactory {

	WebDriver driver = new DriverManager().createDriver();

	@Given("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) open(?:s)? (.+)$")
	public void userOpenPage(String pageName) {
		createPage(pageName, driver).open();
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

	@Then("^(?:[Tt]he |)(?:[Cc]ustomer|[Uu]ser|[Gg]uest|) is redirected to \"(.+)\"$")
	public void userIsRedirectedToWelcomePage(String pageName) {
		Assertions.assertThat(driver.getCurrentUrl()).as("Welcome page is not opened").isEqualTo("https://www.bookdepository.com/?status=welcome&");
		driver.quit();
	}
}
