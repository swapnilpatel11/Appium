package codewithswapnil;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {

	@Test
	public void AppiumTest() throws MalformedURLException {
		
		// AndroidDriver class for automate Android apps
		// for IOS apps IOSDriver class
		// two arguments in AndroidDriver first argument= "url of appium server" and 
		// Appium code -> Appium Server -> Mobile
		
		// One time setup of Appium
		
		// Appium Service builder for Appium server open appium server from this code
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Swapn\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		
		// which device, which version,which application for environment
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SwapnilPhone");
		options.setApp("C:\\Users\\Swapn\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		// two arguments in AndroidDriver first argument= "url of appium server" and 
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		
		// Actual Automation
		// Locators: xpath,id,accessibilityId,classNamem,androidUIAutomator
		
		
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		assertEquals((driver.findElement(By.className("android.widget.TextView")).getText()),"WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Swapnil");
		driver.findElement(By.id("android:id/button1")).click();
		
		
		driver.quit();
		service.stop(); // stop service
		
	}
}
