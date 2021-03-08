package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMAct3 {
	
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User navigates to the PIM option in the menu and click it$")
	public void pim() {
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	        driver=new FirefoxDriver();
			wait=new WebDriverWait (driver,15);
			driver.get("http://alchemy.hguy.co/orangehrm");
			driver.manage().window().maximize();
			 driver.findElement(By.id("txtUsername")).sendKeys("orange");
	    	 driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	    	 driver.findElement(By.id("btnLogin")).click();
	    	 String title =driver.getTitle();
	    	 Assert.assertEquals(title, "OrangeHRM");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
	}
    
	@When("^Click the Add button to add a new Employee$")
	public void add() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee")));
		driver.findElement(By.linkText("Add Employee")).click();
	}
	
    @Then("^Make sure the Create Login Details checkbox is checked$")
    public void checkbox() {
    	driver.findElement(By.id("chkLogin")).click(); 
    }	    	


    @And("^Fill in the \"(.*)\", \"(.*)\", \"(.*)\", and \"(.*)\"$")
    public void employeeDetails(String firstName, String lastName, String employeeID, String userName) {
    	driver.findElement(By.id("firstName")).sendKeys(firstName);
    	driver.findElement(By.id("lastName")).sendKeys(lastName);
    	driver.findElement(By.id("employeeId")).clear();
    	driver.findElement(By.id("employeeId")).sendKeys(employeeID);  	
    	driver.findElement(By.id("user_name")).sendKeys(userName); 
    }
    
    @Then("^Verify that the employee \"(.*)\", \"(.*)\" has been created$")
    public void verifyEmployee(String firstName, String lastName) throws InterruptedException {
    	 driver.findElement(By.xpath("//input[@id='btnSave']")).click();
    	Thread.sleep(1000);
    	//driver.findElement(By.xpath("//h1[text() = 'Personal Details']"));
    	String page = driver.findElement(By.linkText("Employee List")).getText();
    	Assert.assertEquals(page, "Employee List");
    	
    	String FName = driver.findElement(By.xpath("//input[contains(@id, 'FirstName')]")).getAttribute("value");
    	String LName = driver.findElement(By.xpath("//input[contains(@id, 'LastName')]")).getAttribute("value");
    	Assert.assertEquals(FName, firstName);
    	Assert.assertEquals(LName, lastName);
    	System.out.println("The candidate added is: " + FName + " " + LName);
    }
}
