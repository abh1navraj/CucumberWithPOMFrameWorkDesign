package stepDefinations1;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User is on Para Bank home Page")
	public void user_is_on_para_bank_home_page() {
	   DriverFactory.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
	
	}
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedLoginPageTitle) {
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page Title is: " + loginPageTitle);
		Assert.assertTrue(loginPageTitle.contains("ParaBank | Welcome | Online Banking"));
		    
	}

	@When("Cusotmer Login section is present")
	public void cusotme_login_section_is_present() {
	   String customerLoginText = loginPage.getCustomerLoginText();
	   
	   Assert.assertEquals("Customer Login", customerLoginText);
	    
	}

	@And("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
	    loginPage.enterUserName(username);
	    loginPage.enterPassword(password);
	}

	@And("click on login button")
	public void click_on_login_button() {
	    loginPage.clickLoginButton();
	}

	@Then("User should navigated to Home Page")
	public void user_should_get_logged_in() {
		
		String homePageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals("ParaBank | Accounts Overview", homePageTitle);
	
	}

	@And("user enter \"(.*)\" and \"(.*)\"")
	public void user_enter_user_name_and_password(String username, String pwd) {
	    loginPage.enterUserName(username);
	    loginPage.enterPassword(pwd);
	}

	@Then("User should not get navigated to Home Page")
	public void user_should_not_get_navigated_to_Home_Page() {
	   String homePageTitle = loginPage.getLoginPageTitle();
	   Assert.assertEquals("ParaBank | Accounts Overview", homePageTitle);
	   
	}


}
