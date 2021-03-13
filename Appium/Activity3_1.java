package MobilePack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3_1 {
AppiumDriver<MobileElement> driver=null;
@BeforeTest
public void bc() throws MalformedURLException
{
DesiredCapabilities caps=new DesiredCapabilities();
caps.setCapability("DeviceId", "Emulator-5554");
caps.setCapability("PlatformName", "android");
caps.setCapability("appPackage",  "com.google.android.apps.messaging");
caps.setCapability("appActivity",  ".ui.ConversationListActivity");
caps.setCapability("noReset", true);
//Intialization
URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
driver = new AndroidDriver<MobileElement>(appServer, caps);

}

@Test
public void Test1()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//driver.findElementByXPath("//android.widget.TextView[@content-desc='Messages']");
    driver.findElementByXPath("//android.widget.ImageView[@content-desc='Start new conversation']").click();
  MobileElement MblNum=  driver.findElementByXPath("//android.widget.MultiAutoCompleteTextView[@text='Type a name, phone number, or email']");
  MblNum.sendKeys("9346481188");
  	driver.findElementByXPath("//android.widget.LinearLayout").click();
  MobileElement msg=driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[@text='Text message']");
  msg.sendKeys("Hello from Appium");
  driver.findElementByXPath("//android.widget.ImageView").click();
  //assertion
  Assert.assertEquals(msg, "Message sent successfully");
}

@AfterTest
public void ac()
{
driver.quit();	
}




}