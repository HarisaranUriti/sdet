package TestNG_Activities;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project_LMS_Activity9 {

WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
        
        driver.findElement(By.xpath("//li[@id='menu-item-1507']")).click();
       
        driver.findElement(By.xpath("//div[@class='learndash-wrapper']//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        
        String LoggedInTitle = driver.getTitle();
        System.out.println("Loggedin Title is :" + LoggedInTitle);
                
        List<WebElement> dataList = driver.findElements(By.xpath("(//div[@class='caption']//h3[@class='entry-title'])"));
        int dataSize = driver.findElements(By.xpath("(//div[@class='caption']//h3[@class='entry-title'])")).size();
        System.out.println("Number of Courses available is " + dataSize);
        driver.findElement(By.xpath("//img[@class='attachment-course-thumb size-course-thumb wp-post-image']")).click();
        Thread.sleep(2000); 
        String CourseTitle = driver.findElement(By.xpath("//div[@class='ast-single-post-order']//h1[@class='entry-title']")).getText();
        System.out.println("Course Title is :" + CourseTitle);
        
        Assert.assertEquals(CourseTitle, "Social Media Marketing");
        
        try {
        	driver.findElement(By.xpath("//input[@id='learndash-mark-course-complete-24042']"));
        	System.out.println("Mark Complete Button is available");
        	}
        catch(Exception e) 
        	{
        	System.out.println("Mark Complete Button is NOT available");
        	}  
        
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
