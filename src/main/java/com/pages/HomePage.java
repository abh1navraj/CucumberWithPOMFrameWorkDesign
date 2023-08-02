package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver;
	
	By accountsOverview = By.xpath("//h1[@class='title']");
	By logOutButton = By.xpath("//a[text() = 'Log Out']");	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccountSectionText()
	{
		return driver.findElement(accountsOverview).getText();
	}
	
	public boolean checkLogOutButton()
	{
		WebElement logOutBtn = driver.findElement(logOutButton);
		return logOutBtn.isDisplayed();
	}
	
	public LoginPage clickLogOutButton() {
		driver.findElement(logOutButton).click();
		return new LoginPage(driver);
	}

	
}
