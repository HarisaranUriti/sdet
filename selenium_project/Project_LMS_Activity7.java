package TestNG_Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project_LMS_Activity7 {

WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();
            
        //Print the title of the page
        System.out.println("Page title is: " + title);
        
        driver.findElement(By.xpath("//li[@id='menu-item-1507']")).click();
      
        driver.findElement(By.xpath("(//span[@class='uagb-ifb-cta-content-wrapper']//span[@class='uagb-inline-editing '])[1]")).click();
        System.out.println("List of Courses available:"); 
       
        List<WebElement> dataList = driver.findElements(By.xpath("(//div[@class='caption']//h3[@class='entry-title'])"));
        int dataSize = driver.findElements(By.xpath("(//div[@class='caption']//h3[@class='entry-title'])")).size();
        System.out.println("Number of Courses available is " + dataSize);
        for(int i=0;i<dataSize;i++)
        {
        //String Course = dataList.get(i).getText();
        //System.out.println(Course);
        System.out.println(dataList.get(i).getText());
        }                     
    }

	@AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
