package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By Locators
	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.xpath("//input[@value = 'Log In']");
	private By customerLoginSectionText = By.xpath("//h2[text() ='Customer Login']");
	private By successLoginText = By.xpath("//h1[@class ='title']");
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
		
	}
	
	public String getCustomerLoginText()
	{
		String customerLoginText = driver.findElement(customerLoginSectionText).getText();
		
		return customerLoginText;
	}
	
	public String getSuccessLoginMessage() {
		return driver.findElement(successLoginText).getText();
	}
	public HomePage doLogin(String username, String pwd) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
