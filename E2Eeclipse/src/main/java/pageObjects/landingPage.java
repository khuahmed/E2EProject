package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver;

	// Create Constructor
    public landingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Webelements
    private By signin =	By.cssSelector("a[href*='sign_in']"); 		 // click on Login
    private By pageTitle = By.xpath("//*[@id=\"content\"]/div/div/h2");  // title
    private By pageNavigation = By.cssSelector("ul.nav.navbar-nav.navbar-right"); // page navigation title
		
	// Getters to return Webelements
	public WebElement signin() {
		return driver.findElement(signin);		
	}
	
	public WebElement pageTitle() {
		return driver.findElement(pageTitle);		
	}
	
	public WebElement getPageNav() {
        return driver.findElement(pageNavigation);
    }	

}
