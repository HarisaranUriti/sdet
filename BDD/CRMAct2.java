package Stepdefinition;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CRMAct2 {
	WebDriver driver;
	WebDriverWait wait;
	@Given("^open a broswer and login into alchemy CRM webpage$")
	public void openCRMwebpage() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		wait=new WebDriverWait (driver,15);
		driver.get("https://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
		
	}
	 @When("^user logged in and creating a lead$")
	   public void login() {
		   driver.findElement(By.id("user_name")).sendKeys("admin");
		   driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		   driver.findElement(By.name("Login")).click();
		   driver.findElement(By.id("grouptab_0")).click();
		   
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Leads"))).click();
		   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Create Lead']"))).click();
		   
		  	
	   }
   @And("^user adds details like \"(.*)\" and saving$")
   public void details(String lastname) throws InterruptedException {
	   Thread.sleep(1000);
	   driver.findElement(By.id("last_name")).sendKeys(lastname);
	  
	   driver.findElement(By.id("SAVE")).click();
   }
   @Then("^check the results for added leads$")
   public void results() {
	   driver.findElement(By.xpath("//*[@id=\'actionMenuSidebar\']/ul/li[3]/a/div[2]")).click();
	   
   }
  
   @And("^closing browser$")
   public void shutbrowser() {
	   driver.close();
   }
}