package AppiumProj;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Popup_signIn {
	 AppiumDriver<MobileElement> driver = null;
	 WebDriverWait wait;
		@BeforeClass
		public void popuploginExample() throws MalformedURLException  {
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
		public void loginwithvalidCred() {
			driver.get("https://www.training-support.net/selenium");
			wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Selenium']")));
		  //  driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Login Form\"))")).click();
		    driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollDescriptionIntoView(\"Popups Tooltips and Modals\")")).click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Popups']")));
		    driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View[2]/android.view.View")));
		    MobileElement username = driver.findElementByXPath("//android.widget.EditText[@resource-id='username']");
		    MobileElement Password = driver.findElementByXPath("//android.widget.EditText[@resource-id='password']");
		    MobileElement login = driver.findElementByXPath("//android.widget.Button[@text='Log in']");
		    username.sendKeys("admin");
		    Password.sendKeys("password");
		    login.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Welcome Back, admin']")));
		    String welcomenote = driver.findElementByXPath("//android.view.View[@text='Welcome Back, admin']").getText();
		    Assert.assertEquals(welcomenote,"Welcome Back, admin");
		    System.out.println(welcomenote);
		   
		}
		@Test(priority=2)
		public void loginwithInvalidCred() {
			
			driver.findElementByXPath("//android.widget.Button[@text='Sign In']").click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View[2]/android.view.View")));
			
			MobileElement username = driver.findElementByXPath("//android.widget.EditText[@resource-id='username']");
		    MobileElement Password = driver.findElementByXPath("//android.widget.EditText[@resource-id='password']");
		    MobileElement login = driver.findElementByXPath("//android.widget.Button[@text='Log in']");
		    username.sendKeys("admin");
		    Password.sendKeys("pa$sword");
		    login.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[@text='Invalid Credentials']")));
		    String errormsg = driver.findElementByXPath("//android.view.View[@text='Invalid Credentials']").getText();
		    Assert.assertEquals(errormsg,"Invalid Credentials");
		    System.out.println(errormsg);
			
		} 
		
		@AfterClass	
	    public void afterClass() {	
	        driver.quit();	
	 }
}