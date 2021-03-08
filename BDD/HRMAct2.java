package Stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMAct2 {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on OrangeHRM webpage$")
    public void browseropen() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harrisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
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
	@Given("^User goes to the Recruitment page$")
	public void Recruitment() throws InterruptedException {
		 Thread.sleep(3000);
    	driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
	}
	    	 
	    	 @When("^User clicks on the Add button to add candidate information$")
	    	 public void Candidates() {
			driver.findElement(By.linkText("Candidates")).click();
			driver.findElement(By.id("btnAdd")).click();
		}
	    
	    @Then("^User fills in the details of the candidate$")
	    public void candidateDetails() {
	    	driver.findElement(By.xpath("//input[contains(@id, 'firstName')]")).sendKeys("Sahasra"); 
	    	driver.findElement(By.xpath("//input[contains(@id, 'lastName')]")).sendKeys("sri1"); 
	    	driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys("test@gmail.com"); 
	    	
	    	Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'vacancy')]")));
	    	dropdown.selectByVisibleText("Automation Tester");  	
	    }	    	


	    @And("^Upload a resume to the form$")
	    public void resume() {
	    	driver.findElement(By.xpath("//input[contains(@id, 'resume')]")).sendKeys("C:\\Users\\Harisaran Uriti\\sampleresume.txt"); 
	    	driver.findElement(By.id("btnSave")).click();
	    }
	    
	    @Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	    public void verifyCandidate() throws InterruptedException {
	    	
	    	driver.findElement(By.id("btnBack")).click();
			 
			 driver.findElement(By.xpath("//input[@id='candidateSearch_candidateName']")).sendKeys("Sahasra sri1",Keys.ENTER);
			 driver.findElement(By.name("btnSrch")).click();
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='resultTable']/tbody/tr")));
	    	
			 List<WebElement> candname = driver.findElements(By.xpath("//*[@id=\'resultTable\']/tbody/tr[1]/td[3]/a"));
			 for(int i=1;i<=candname.size();i++) {
				 String candidate= driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]")).getText();
				 if(candidate.contains("Sahasra sri1")) {
					 Assert.assertEquals(candidate, "Sahasra sri1");
					 System.out.println("The candidate added is: " + candidate);
	    }
			 }
	    }
}
