package Training.E2Eeclipse;

import java.io.IOException; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class HomePage extends base {
	
	// Create local driver so intializerDriver 
	// doesnt get overwritten while running tests parrallely.
	public WebDriver driver;
	
	// using log4j
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void befTest() throws IOException {
		driver=intializeDriver();
		log.info("Driver is initiated");
	}
	
	
	@Test  (dataProvider = "getData")
	public void basePageLanding(String email, String password) {
				
		driver.get(prop.getProperty("url"));
	
		// click on login button
		landingPage l = new landingPage(driver);
		l.signin().click();
	
		// Enter Email Address and Passwords
        loginPage lP = new loginPage(driver);
        lP.emailAddress().sendKeys(email);  // Enter Email Address
        lP.password().sendKeys(password);   // Enter Password
        lP.login().click();                 // Enter on Login button           
    	
        log.info("loginPage parameter run");
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
		log.info("Driver closed");
	}
	
    @DataProvider
    public Object[] getData(){
        Object [][] testData = new Object[3][2];

        //1st data set
        testData[0][0] = "firstEmail@abc.com";
        testData[0][1] = "passing";

        //2nd Data Set
        testData[1][0] = "secondEmail@abc.com";
        testData[1][1] = "passpass";

        //3rd Data set
        testData[2][0] = "thirdEmail@abcd.com";
        testData[2][1] = "1234";

        return testData;
    }
}
