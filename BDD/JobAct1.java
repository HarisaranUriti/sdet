package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class JobAct1 {
	WebDriver driver;
	WebDriverWait wait;
	@Given("^open a webpage$")
	public void openbrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		wait=new WebDriverWait (driver,15);
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		driver.manage().window().maximize();
	}
   @When("^user logged in and lands on webpage$")
   public void login() {
	   driver.findElement(By.id("user_login")).sendKeys("root");
	   driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
	   driver.findElement(By.id("wp-submit")).click();
	   driver.findElement(By.xpath("//*[@id=\"menu-users\"]/a/div[3]")).click();
   }
   @And("^trying to add new user and filling necessary details$")
   public void addnewuser() {
	driver.findElement(By.xpath(" //*[@id=\"menu-users\"]/ul/li[3]/a")).click();
	driver.findElement(By.id("user_login")).sendKeys("Gogula11");
	driver.findElement(By.id("email")).sendKeys("sahasraasri@gmail.com");
	driver.findElement(By.id("first_name")).sendKeys("sahasraa");
	driver.findElement(By.id("last_name")).sendKeys("sri");
	//driver.findElement(By.className("button wp-generate-pw hide-if-no-js")).click();
	driver.findElement(By.xpath("//input[@id='createusersub']")).click();
	//driver.findElement(By.id("pass1")).sendKeys("pass1");
	//driver.findElement(By.id("createusersub")).click();
   }
   @Then("^user was created and verify$")
   public void searchuser() throws InterruptedException {
	driver.findElement(By.id("user-search-input")).sendKeys("Gogula11");
	driver.findElement(By.id("search-submit")).click();
	Thread.sleep(1000);
	String Username= driver.findElement(By.xpath("//td[@data-colname='Username']")).getText();
	System.out.println("New user is added: " + Username );
	Assert.assertEquals(Username, "Gogula11");  
   }
   @And("^shut the browser$")
   public void close() {
	   driver.close();
   }
}