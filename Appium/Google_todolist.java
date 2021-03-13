package AppiumProj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Google_todolist {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void todolistExample() throws MalformedURLException  {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "Pixelemulator");
			caps.setCapability("deviceId", "emulator-5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.android.chrome");
			caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
			caps.setCapability("noReset", true);
			
			 
		     // Initialize driver
		      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		      wait = new WebDriverWait(driver, 5);
		}
		
		@Test
		public void todoList() throws InterruptedException {
			driver.get("https://www.training-support.net/selenium");
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]")));

		    MobileElement taskinput= driver.findElementByXPath("//*[@resource-id='taskInput']");
			MobileElement addbtn =driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Add Task']"));
			
			ArrayList<String> tasks = new ArrayList<String>();
			tasks.add("Add tasks to list");
			tasks.add("Get number of tasks");
			tasks.add("Clear the list");
			
			for(int i=0;i< tasks.size();i++) {
				taskinput.sendKeys(tasks.get(i));
				addbtn.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			}
			
		    for (int j=0;j<tasks.size();j++) {
		    	String textpath = "//android.view.View[@text= '"+tasks.get(j)+"']";	
		    	driver.findElementByXPath(textpath).click();
		    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    }
			
		//clear the list
			driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[3]")));
			
		boolean	istaskDisplayed= true;
		
		try {
			driver.findElementByXPath("//android.view.View[@text='Get number of tasks']");
			
		}
			catch(Exception e) {
				istaskDisplayed=false;
			}
		Assert.assertEquals(false, istaskDisplayed);
			
    }
		
		@AfterClass	
	    public void afterClass() {	
	        driver.quit();	
	 }
		

}