package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	@Given("^I am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String expectedTitle) throws Exception {
		DriverFactory.getDriver().get("https://secure-sandbox.modulrfinance.com/");
	    Thread.sleep(5000);
		String Title=loginPage.getLoginPageTitle();
	    Assert.assertTrue(Title.contains(expectedTitle));
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Exception {
	    Thread.sleep(1000);
	    loginPage.enterUsername(username);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Exception {
	    loginPage.enterPassword(password);
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Exception {
	    loginPage.clickOnLogin();
	    Thread.sleep(1000);
	}

	@Then("^I am logged in \"([^\"]*)\"$")
	public void i_am_logged_in(String expectedTitle) throws Exception {
	    Thread.sleep(5000);
		String Title=loginPage.getLoginPageTitle();
	    Assert.assertTrue(Title.contains(expectedTitle));
	}
	
	@Then("I click on {string} button")
	public void click_on_button(String string) {
		if(string.equalsIgnoreCase("login"))
		{
			loginPage.clickOnLogin();
			
		}else if(string.equalsIgnoreCase("Request a Reset"))
		{
			loginPage.clickOnRequestReset();;
			
		}else if(string.equalsIgnoreCase("Forgot Password"))
		{
			loginPage.clickOnForgotPassword();
		}
		
	}

	@And("I am able to see {string}")
	public void i_am_able_to_see(String expectedErrormsg) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		if(expectedErrormsg.equalsIgnoreCase("This field is required"))
		{
			String actualErrormsg = loginPage.getFieldRequiredMsg();
		    Assert.assertTrue(actualErrormsg.contains(expectedErrormsg));
		}
		else if(expectedErrormsg.equalsIgnoreCase("The username or password is incorrect"))
		{
			String actual = loginPage.getIncorrectFieldErrorMsg();
	        String[] arrOfStr = actual.split(".\n");
	       	String actualErrormsg=arrOfStr[0];
			DriverFactory.getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

			 Assert.assertTrue(expectedErrormsg.contains(actualErrormsg));
	    }else if(expectedErrormsg.equalsIgnoreCase("Modulr Payments"))
	    {
			String Title=loginPage.getAccountPageTitle();
		    Assert.assertTrue(Title.contains(expectedErrormsg));

	    }else if(expectedErrormsg.equalsIgnoreCase("Email sent"))
	    {
			String actual=loginPage.getEmailSentText();
		    Assert.assertTrue(actual.contains(expectedErrormsg));

	    }

		}
	
	@And("I enter reset username as {string}")
	public void I_enter_reset_username (String value) {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameInput")));
		loginPage.resetUsername(value);
	}

}
