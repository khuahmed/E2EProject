package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver intializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		
		prop.load(fis);
		
		// mvn test -Dbrowser=chrome
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		// firefox
        if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\Selenium - Eclipse\\Selenium Notes\\invoke web browsers\\geckodriver.exe");
            driver = new FirefoxDriver();
            }
        // chrome
	    else if (browserName.contains("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", "D:\\Selenium - Eclipse\\Selenium Notes\\invoke web browsers\\chromedriver.exe");
            
	    	ChromeOptions options = new ChromeOptions();  // create ChromeOptions object
	    	
	    	if (browserName.contains("headless")) {   // headless argument will be added only
	    		options.addArguments("headless");     // if browser name contains word headless
	    	}	    	
	    	
	    	driver = new ChromeDriver(options);
        }

        // timeout which applies to the whole project
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;	
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);  // this file is at a virtual place
		
		// copy file from virtual location to loacl system
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));	
		
		return destinationFile;
	}
}
