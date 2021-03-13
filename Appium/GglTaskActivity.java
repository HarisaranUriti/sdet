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

	public class GglTaskActivity {
		 AppiumDriver<MobileElement> driver = null;
		 WebDriverWait wait;
			@BeforeClass
			public void smsExample() throws MalformedURLException  {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "Pixelemulator");
				caps.setCapability("deviceId", "emulator-5554");
				caps.setCapability("platformName", "Android");
				caps.setCapability("appPackage", "com.google.android.apps.tasks");
				caps.setCapability("appActivity", ".ui.TaskListsActivity");
				caps.setCapability("noReset", true);
				
				 
			     // Initialize driver
			      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			      wait = new WebDriverWait(driver, 5);
			}
			
			@Test
			public void addTasks() {
				
				//click on create new task button
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				MobileElement createbtn = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");
				createbtn.click();
				MobileElement addtask=driver.findElementByXPath("//android.widget.EditText[@text='New task']");
				addtask.sendKeys("Complete Activity with Google Tasks");
				MobileElement savebtn = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
				savebtn.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
				
		        //adding second task
				
				createbtn.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
				addtask.sendKeys("Complete Activity with Google Keep");
				savebtn.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
				
				//adding third task
				
				createbtn.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@text='New task']")));
				addtask.sendKeys("Complete the second Activity Google Keep");
				savebtn.click();
				
				String task1 = driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Tasks']").getText();
				Assert.assertEquals(task1,"Complete Activity with Google Tasks");
				String task2 = driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Keep']").getText();
				Assert.assertEquals(task2,"Complete Activity with Google Keep");
				String task3 = driver.findElementByXPath("//android.widget.TextView[@text='Complete the second Activity Google Keep']").getText();
				Assert.assertEquals(task3,"Complete the second Activity Google Keep");
				
				//printing tasks to console
				System.out.println(task1);
				System.out.println(task2);
				System.out.println(task3);
				
				 


			}
			@AfterClass
			public void teardown() {
				driver.quit();
				
			}

	}

