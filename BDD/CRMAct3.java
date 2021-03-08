package Stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages.PickleStepArgument.PickleTable.PickleTableRow.Builder;

public class CRMAct3 {
	WebDriver driver;
	WebDriverWait wait;
	@Given("^User navigates to Activities, Meetings, and Schedule a meeting$")
    public void meeting() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		wait=new WebDriverWait (driver,15);
		driver.get("https://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.name("Login")).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("grouptab_3"))).click();
    	driver.findElement(By.linkText("Meetings")).click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'Schedule Meeting']"))).click();
     	
    }
    
	@When("^User gives details$")
	public void meetingName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_first_name")));
		driver.findElement(By.id("name")).sendKeys("Test Meet");
	}
	
	@And("^User searches and add members$")
	
	public void search(DataTable searchTable) throws InterruptedException {
     Thread.sleep(1000);

		List<List<String>> search = searchTable.asLists();
		
		for(int i = 1; i < search.size(); i++) {
			driver.findElement(By.id("search_first_name")).sendKeys(search.get(i).get(0));
			driver.findElement(By.id("search_last_name")).sendKeys(search.get(i).get(1));
			//driver.findElement(By.id("search_email")).sendKeys(search.get(i).get(2));
			Thread.sleep(1000);
			
			driver.findElement(By.id("invitees_search")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("invitees_add_1"))).click();
			
			driver.findElement(By.id("search_first_name")).clear();
			driver.findElement(By.id("search_last_name")).clear();
			driver.findElement(By.id("search_email")).clear();
			}
		driver.findElement(By.id("SAVE_HEADER")).click();		
	}
	
    @Then("^Navigate to View Meetings page and confirm creation of the meeting$")
    public void verfiyMeeting() {
    	driver.findElement(By.xpath("//*[@id=\'actionMenuSidebar\']/ul/li[2]/a/div[2]"));
    	String Name = driver.findElement(By.xpath("//h2[@class = 'module-title-text']")).getText();
    	Assert.assertEquals(Name, "TEST MEET");
    	System.out.println("The scheduled meeting is: " + Name);
    }

}