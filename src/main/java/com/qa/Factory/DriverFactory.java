package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to create a ThreadLocal driver on the basis of given browser value
	 * @param browser
	 * @return This will return tldriver
	 */
	public WebDriver init_Driver(String browser) {
		
		if(browser.equals("Chrome"))
		{
			driver = WebDriverManager.chromedriver().create();
			tlDriver.set(driver);
		}
		else if(browser.equals("Edge"))
		{
			driver = WebDriverManager.edgedriver().create();
			tlDriver.set(driver);
		}
		else if(browser.equals("firefox"))
		{
			driver = WebDriverManager.firefoxdriver().create();
			tlDriver.set(driver);
		}
		else if(browser.equals("safari"))
		{
			
			tlDriver.set(new SafariDriver());
		}
		else
		{
			System.out.println("Incorrect browser value: " + browser + "\nPlease Pass the correct browser value");
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	/**
	 * This method will get a driver with ThreadLocal
	 * @return This will return a threadLocal driver
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

}
