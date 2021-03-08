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

public class JobAct3 {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^Open browser with ​Alchemy Jobs site$")
	public void openbrowser() {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
	wait=new WebDriverWait(driver,15);
	driver.get("https://alchemy.hguy.co/jobs/");
	driver.manage().window().maximize();
		
	}
	@And("^Go to Post a Job page$")
	public void PostJob() {
	driver.findElement(By.xpath("//*[@id=\'menu-item-26\']/a"));
		
	}
    @When("^User enters Job title as \"(.*)\"$")
	public void jobdetails(String jobtitle) {
    //driver.findElement(By.xpath("//*[@id=\'application\']")).sendKeys(email);
	driver.findElement(By.xpath("//*[@id=\'job_title\']]")).sendKeys(jobtitle);
	
	}
    @Then("^Type in Description as \"(.*)\"$")
    public void desc(String desc) {
    driver.findElement(By.xpath("//*[@id=\'tinymce\']/p[1]")).sendKeys(desc);
    	
	}
    @And("^Enter Application email as \"(.*)\" and company as \"(.*)\"$")
    public void jobdetails1(String email, String Company) {
    driver.findElement(By.xpath("//*[@id=\'application\']")).sendKeys(email);
    driver.findElement(By.id("company_name")).sendKeys(Company);
		
	}
    @Then ("^Click submit$")
public void applyandclose() {
    	driver.findElement(By.name("submit_job")).click();
    	driver.findElement(By.id("job_preview_submit_button")).click();
	}

    @And ("^Then View listing in Alchemy Jobs for \"(.*)\"$")
public void Joblist() {
    driver.findElement(By.xpath("//*[@class=\'main-navigation\']/ul[1]/li[1]/a")).click();
    	
    	
		
	}


}

