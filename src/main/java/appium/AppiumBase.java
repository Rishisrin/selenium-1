package appium;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Finder;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import sikuli.SikuliUtils;
import utils.Element_Screenshot;

public class AppiumBase {
	AndroidDriver<AndroidElement> driver;

	// driver.findElementByAndroidUIAutomator(“new UiScrollable(new
	// UiSelector()).scrollIntoView(text(“Enter your element”))”);
	@Test
	public void aTestBase() throws Exception {
		File f = new File("src");
		File f1 = new File(f, "troopm.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP, f1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability("autoGrantPermissions", true);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("appPackage", "com.tvisha.troopmessenger");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElementById("com.tvisha.troopmessenger:id/userId").sendKeys("rakesh.adupa@tvisha.in");
		driver.findElementById("com.tvisha.troopmessenger:id/password").sendKeys("recommend139");
		driver.findElementById("com.tvisha.troopmessenger:id/submitImg").click();
		
		Thread.sleep(50000);
		try {
			driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
		} catch (Exception e) {
			driver.findElementsById("com.tvisha.troopmessenger:id/item").get(0).click();
		}
		Thread.sleep(5000);
		System.err.println("Go ahead===========");
		Thread.sleep(15000);
		int msgSize = driver.findElementsById("com.tvisha.troopmessenger:id/msgSentStatus").size();
		WebElement msgStatus = driver.findElementsById("com.tvisha.troopmessenger:id/msgSentStatus").get(msgSize - 1);

		File a = Element_Screenshot.testElement_Screenshot(driver, msgStatus);
		
		
		//SikuliUtils.compareImageInSikuli("/home/rakesh/Documents/Bug reports/Mr&Mrs/test.png", a.getAbsolutePath());

	}

}
