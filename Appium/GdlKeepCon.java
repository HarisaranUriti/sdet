package AppiumProj;
   import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.interactions.Actions;
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

	public class GdlKeepCon {
		 AppiumDriver<MobileElement> driver = null;
		 WebDriverWait wait;
			@BeforeClass
			public void smsExample() throws MalformedURLException  {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "Pixelemulator");
				caps.setCapability("deviceId", "emulator-5554");
				caps.setCapability("platformName", "Android");
				caps.setCapability("appPackage", "com.google.android.keep");
				caps.setCapability("appActivity", ".activities.BrowseActivity");
				caps.setCapability("noReset", true);
				
				 
			     // Initialize driver
			      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			      wait = new WebDriverWait(driver, 5);
			}
			
			@Test(priority=1)
			public void addNoteInKeepNote() {
				MobileElement newnote= driver.findElementById("com.google.android.keep:id/new_note_button");
				newnote.click();
				MobileElement titlenote= driver.findElementById("com.google.android.keep:id/editable_title");
				titlenote.sendKeys("SDET COURSE");
				MobileElement notedesc= driver.findElementById("com.google.android.keep:id/edit_note_text");
				notedesc.sendKeys("Mobile testing project activities");
				MobileElement navback= driver.findElement(MobileBy.AccessibilityId("Navigate up"));
				navback.click();
				
				String titletext = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
				String desctext = driver.findElementById("com.google.android.keep:id/index_note_text_description").getText();
				
				Assert.assertEquals(titletext ,"SDET COURSE");
				Assert.assertEquals(desctext, "Mobile testing project activities");
				}  
			@Test(priority=2)
			public void addRemainder() throws InterruptedException {
				
				MobileElement firstnotetile= driver.findElementById("com.google.android.keep:id/browse_note_interior_content");
				firstnotetile.click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				MobileElement remainderbtn= driver.findElementById("com.google.android.keep:id/menu_reminder");
				remainderbtn.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/bs_list_view")));
				MobileElement pickdatetime= driver.findElementByXPath("//android.widget.TextView[@text='Pick a date & time']");
				pickdatetime.click();
				driver.findElementById("com.google.android.keep:id/date_spinner").click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")));
				driver.findElementById("com.google.android.keep:id/reminder_date_tomorrow").click();
				driver.findElementById("com.google.android.keep:id/time_spinner").click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout")));
				driver.findElementByXPath("//android.widget.TextView[@text='Night']").click();
				driver.findElementById("com.google.android.keep:id/save").click();
				MobileElement navback= driver.findElement(MobileBy.AccessibilityId("Navigate up"));
				navback.click();
				MobileElement muloptions= driver.findElement(MobileBy.AccessibilityId("Open navigation drawer"));
				muloptions.click();
				driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders").click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				String alarm=driver.findElementByXPath("//android.widget.TextView[@text='Tomorrow, 8:00 PM']").getText();
				Assert.assertEquals(alarm, "Tomorrow, 8:00 PM");
				
				
				
			}
			 @AfterClass	
			    public void afterClass() {	
			        driver.quit();	
			 }
			

	}



