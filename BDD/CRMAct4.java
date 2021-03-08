package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"Stepdefinition"},
    tags = "@HRMAct3",
    plugin= {"html:Reports/htmlreports.html"},
    monochrome=true
    )

public class ActRunner {
	
	

}package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CRMAct4 {
	
	WebDriver driver;
	WebDriverWait wait;
	
	

		 @Given("^User navigates to All, Products, and Create Product$")
	    public void product() throws InterruptedException {
			
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
				driver=new FirefoxDriver();
				wait=new WebDriverWait (driver,15);
				 Actions actions = new Actions(driver);
				driver.get("https://alchemy.hguy.co/crm");
				driver.manage().window().maximize();
				driver.findElement(By.id("user_name")).sendKeys("admin");
				driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
				driver.findElement(By.name("Login")).click();
	    	   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_5")));
	    	
	    	  driver.findElement(By.id("grouptab_5")).click();
	    	  actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	  		Thread.sleep(3000);
	    	
	    	
	    	driver.findElement(By.xpath("//*[@id=\'toolbar\']/ul/li[7]/span[2]/ul/li[25]/a")).click();
	    	
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Create Product']")));
	    	driver.findElement(By.xpath("//div[text() = 'Create Product']")).click();	    	
	    }
	    
	    @And("^User enters details about the product like \"(.*)\" and \"(.*)\"$")
	    public void productDetails(String Name, String Price) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id = 'contact']")));
	    	driver.findElement(By.id("name")).sendKeys(Name);
	    	driver.findElement(By.id("price")).sendKeys(Price);
	    	driver.findElement(By.id("SAVE")).click();
	    }
	    @Then("^User navigates to View Products page to see \"(.*)\" listed$")
	    public void productDetails(String Name) throws InterruptedException {
	    	driver.findElement(By.xpath("//*[@id=\'actionMenuSidebar\']/ul/li[2]/a/div[2]")).click();
	    	Thread.sleep(1000);
	    	String productName = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[3]")).getText();
	    	Thread.sleep(1000);
	    	Assert.assertEquals(productName, Name);
	    	System.out.println("The product created is: " + productName);	
	    }
	    
	
//	    @After("@CRM")
//	    public void logout() {
//	    	builder.moveToElement(driver.findElement(By.xpath("//span[text() = 'admin']"))).build().perform();
//	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
//	       	builder.moveToElement(driver.findElement(By.linkText("Logout"))).build().perform();
//	    	driver.findElement(By.linkText("Logout")).click();
//	    }
	    }
