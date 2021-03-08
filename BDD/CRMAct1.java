package Stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CRMAct1 {
	WebDriver driver;
	WebDriverWait wait;
	@Given("^Open the browser to the ​Alchemy CRM​ site and login$")
	public void openCRMwebpage() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		wait=new WebDriverWait (driver,15);
		driver.get("https://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
		
	}
	 @When("^user logged in and lands on CRMwebpage$")
	   public void login() {
		   driver.findElement(By.id("user_name")).sendKeys("admin");
		   driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		   driver.findElement(By.name("Login")).click();
	   }
   @And("^Count the number and printing of Dashlets on the homepage$")
   public void countdashlets() throws InterruptedException {
	   List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
	   Thread.sleep(1000);
	   dashlets=driver.findElements(By.className("dashlet-title"));
	   Assert.assertEquals(dashlets.size(),7);
	   System.out.println("The number of dashlets are " + dashlets.size());
	   for (WebElement webElement : dashlets) {
           String name = webElement.getText();
           System.out.println(name);
       }
 
   }
  
   @And("^Close the browser$")
   public void close() {
	   driver.close();
   }
}