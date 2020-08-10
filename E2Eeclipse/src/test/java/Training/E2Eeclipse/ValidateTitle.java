package Training.E2Eeclipse;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageObjects.landingPage;

public class ValidateTitle extends base {
	
	// Create local driver so intializerDriver 
	// doesnt get overwritten while running tests parrallely.
	public WebDriver driver;
	
	// using log4j
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void befTest() throws IOException {
		driver=intializeDriver();
		log.info("Driver is initiated");
	}
		
	@Test
	public void basePageTitle() {
				
		driver.get(prop.getProperty("url"));
	
		// click on login button
		landingPage l = new landingPage(driver);
		String pTitle = l.pageTitle().getText();
		
		// Adding Assertions
        Assert.assertEquals(pTitle, "FEATURED COURSESs"); // validate text
        log.info("Validate text Assertion");     
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
