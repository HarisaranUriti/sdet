package TestNG_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project_LMS_Activity3 {

	WebDriver driver;
	    
	    @BeforeMethod
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("https://alchemy.hguy.co/lms");
	    }

	    @Test
	    public void exampleTestCase() throws InterruptedException {
	        // Check the title of the page
	        String title = driver.getTitle();
	            
	        //Print the title of the page
	        System.out.println("Page title is: " + title);
	        
	       String FirstInfoBox = driver.findElement(By.xpath("//div[@class='uagb-ifb-title-wrap']//h3[@class='uagb-ifb-title']")).getText();
	        System.out.println("First Info Box text is :" + FirstInfoBox);
	        
	        Assert.assertEquals(FirstInfoBox, "Actionable Training");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        //Close the browser
	        driver.quit();
	    }

	}