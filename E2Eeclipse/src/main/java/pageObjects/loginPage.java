package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;

	// Create Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }


    // Webelements
    private By emailAddress = By.id("user_email");	// Email Address
		
    private By password = By.id("user_password"); 	// Password
	
    private By login = By.cssSelector("[value='Log In']"); // login Button
	
		
	
	// Getters to return Webelements
	
	public WebElement emailAddress() {
		return driver.findElement(emailAddress);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
    public WebElement login() {
        return driver.findElement(login);
    }
}
