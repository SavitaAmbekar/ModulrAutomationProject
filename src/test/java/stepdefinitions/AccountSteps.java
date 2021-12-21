package stepdefinitions;

import java.util.List;
import java.util.Map;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountSteps {
	
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	
	@Given("user has alreday login to the application")
	public void user_has_alreday_login_to_the_application(DataTable dataTable) {
		List<Map<String,String>> crdential=dataTable.asMaps();
		String uname=crdential.get(0).get("username");
		String pwd=crdential.get(0).get("password");
		
		DriverFactory.getDriver().get("https://secure-sandbox.modulrfinance.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginpage.doLogin(uname, pwd);
	    
	}

	
}
