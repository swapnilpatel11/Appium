package codewithswapnil;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class Miscellaneous extends BaseTest {

	@Test
	public void orientationDemo() {
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
	driver.findElement(By.id("android:id/checkbox")).click();
	
	// Code for roation
	DeviceRotation landScape = new DeviceRotation(0,0,90);
	driver.rotate(landScape);
	
	
	 driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
//	driver.findElement(By.id("android:id/title")).click();

	String alertText = driver.findElement(By.className("android.widget.TextView")).getText();
//	String alertText = driver.findElement(By.id("android:id/alertTitle")).getText();
	 assertEquals(alertText, "WiFi settings");
	driver.findElement(By.id("android:id/edit")).sendKeys("Swapnil");
	driver.findElement(By.id("android:id/button1")).click();
	}
	
}
