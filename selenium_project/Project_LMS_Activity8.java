package TestNG_Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project_LMS_Activity8 {

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
        
        driver.findElement(By.xpath("//li[@id='menu-item-1506']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Harisaran");
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("xyz.com@gmail.com");
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys("Subject");
        driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("Details");
        System.out.println("ENtered values");
        driver.findElement(By.xpath("//button[@id='wpforms-submit-8']")).click();
        
        System.out.println("Submitted Request");
        String Description = driver.findElement(By.xpath("//div[@id='uagb-column-3c1a3492-d74d-4e1e-b35b-69d0e288d4ca']")).getText(); 
        System.out.println("Submitted Request" + Description);
        Assert.assertEquals(Description, "Thanks for contacting us! We will be in touch with you shortly.");
       
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

