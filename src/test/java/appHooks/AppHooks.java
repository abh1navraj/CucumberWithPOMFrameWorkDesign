package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	
	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;
	
	
	@Before(order = 0)
	public void getProperty() {
		
		configReader = new ConfigReader();
		prop = configReader.initProperties();
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_Driver(browserName);
		
		
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
		
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed())
		{
			//take screenshot
			
			String screeenshotName = scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screeenshotName);
			
		}
		
	}

}
