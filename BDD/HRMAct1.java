package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMAct1 {
		
	WebDriver driver;
	WebDriverWait wait;
	
		@Given("^User is on OrangeHRM page and logs in$")
	    public void Openbrowser() {
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
	    }
		
	//Job Vacancies
		@Given("^User navigates to the Recruitment page$")
		public void Recruitment() throws InterruptedException {
			 Thread.sleep(3000);
	    	driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
		}
			
		@When("^User clicks on the Vacancies menu item to navigate to the vacancies page$")
    	public void Vacancies() {
			driver.findElement(By.linkText("Vacancies")).click();
		}
	    
	    @Then("^Click on the Add button to navigate to the Add Job Vacancy form$")
	    public void addNew() {
	    	driver.findElement(By.id("btnAdd")).click();
	    }
	    
	    @And("^Fill out the details like \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
	    public void vacancyDetails(String jobTitle, String vacancyName, String manager, String positions) {
	    	Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'jobTitle')]")));
	    	dropdown.selectByVisibleText(jobTitle);  	
	    	
	    	driver.findElement(By.id("addJobVacancy_name")).sendKeys(vacancyName);
	    	driver.findElement(By.xpath("//input[contains(@class, 'FormatHint')]")).sendKeys(manager);   	
	    	driver.findElement(By.xpath("//input[contains(@id, 'noOfPositions')]")).sendKeys(positions);
	    }


	    @When("^User clicks the Save button$")
	    public void Save() {
	    	//driver.findElement(By.id("btnSave")).click();	
	    }
	    
	    @Then("^Verify that the vacancy was created for \"(.*)\"$")
	    public void verifyVacany(String jobTitle) {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'Edit')]")));
	    	String vacancy = driver.findElement(By.xpath("//h1[contains(text(), 'Edit')]")).getText();
	    	Assert.assertEquals(vacancy, "Edit Job Vacancy");
	    	
	    	String Title = driver.findElement(By.xpath("//select[contains(@id, 'jobTitle')]/option[@selected = 'selected']")).getText();
	    	Assert.assertEquals(Title, jobTitle);
	    	System.out.println("The vacancy added is: " + Title);
	    }
}