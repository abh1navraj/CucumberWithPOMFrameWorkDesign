package stepDefinations1;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	@Given("user is already logged in to the application")
	public void user_is_already_logged_in_to_the_application(DataTable dataTable) {
	  List<Map<String, String>>credential = dataTable.asMaps();
	  String userName = credential.get(0).get("username");
	  String pwd = credential.get(0).get("password");
	  
	  DriverFactory.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
	  homePage = loginPage.doLogin(userName, pwd);
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
	  String homePageTitle = homePage.getPageTitle();
	  Assert.assertEquals("ParaBank | Accounts Overview", homePageTitle);
	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page()
	{
		System.out.println("home page title is: " + homePage.getPageTitle());
	}

	@Then("title should be {string}")
	public void title_should_be(String string) {
		String homePageTitle = homePage.getPageTitle();
		Assert.assertEquals("ParaBank | Accounts Overview", homePageTitle);
		
	}

	@Then("{string} section should be present")
	public void section_should_be_present(String expectedAccountSectionText) {
	   String actualAccountSectionText = homePage.getAccountSectionText();
	   Assert.assertEquals(expectedAccountSectionText, actualAccountSectionText);
	}

	@Then("Log out button should be displayed")
	public void log_out_button_should_be_displayed() {
	  Assert.assertTrue(homePage.checkLogOutButton());
	}

	@Given("user click on Log out button")
	public void user_click_on_log_out_button() {
	    loginPage = homePage.clickLogOutButton();
	}

	@Then("user should get Logged out from home page")
	public void user_should_get_logged_out_from_home_page() {
		String homePageTitle = loginPage.getLoginPageTitle();
		Assert.assertNotEquals("ParaBank | Accounts Overview", homePageTitle);
		
	}




}
