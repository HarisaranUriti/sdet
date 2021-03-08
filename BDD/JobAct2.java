package Stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class JobAct2 {
	WebDriver driver;
	WebDriverWait wait;

	@Given("^open alchemy jobs webpage and navigate to jobs page$")
	public void openbrowser() {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Harisaran Uriti\\Downloads\\3. IBM  Work files\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
	wait=new WebDriverWait(driver,15);
	driver.get("https://alchemy.hguy.co/jobs/");
	driver.manage().window().maximize();
		
	}
	@And("^finding keywords in search input field$")
	public void Keywordsearch() {
		driver.findElement(By.xpath("//*[@class=\'main-navigation\']/ul[1]/li[1]/a")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("Fullstacktester");
		
	}
    @Then("^search for jobs changing the job type and searching for fulltime job$")
public void jobsearch() {
    	driver.findElement(By.xpath("//*[@class=\'job_types\']/li[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@class=\'internship\']/input")).click();
		driver.findElement(By.xpath("//*[@class=\'part-time\']/input")).click();
		driver.findElement(By.xpath("//*[@class=\'temporary\']/input")).click();
		driver.findElement(By.xpath("//*[@class=\"search_submit\"]/input")).click();
		
	}

    @Then("^finding title of the job and to print it$")
public void jobtitle() throws InterruptedException {
    	//driver.findElement(By.xpath("//h3[text() = 'FullStackTesters41']")).click();
    	//String jobtitle=driver.findElement(By.xpath("//h3[text() = 'FullStackTesters41']")).getText();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\'post-7\']/div/div/ul/li[1]")).click();
    	String jobtitle=driver.findElement(By.xpath("//*[@id=\'post-2864\']/div/header/div/h1")).getText();
    	System.out.println("Job title is: " + jobtitle);
    	Assert.assertEquals(jobtitle, "FullStackTesters41");
	}
    @And("^applying for a job and closing browser$")
public void applyandclose() {
    	driver.findElement(By.xpath("//input[@type='button']")).click();
    	driver.close();
		
	}

}