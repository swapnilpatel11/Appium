package codewithswapnil;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class Miscellaneous extends BaseTest {
	
	@Test
	public void orientationDemo() {
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		
		// we can use to start activity in this way in new version
		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
//		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		driver.findElement(By.id("android:id/checkbox")).click();

		// Code for roation
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		// driver.findElement(By.id("android:id/title")).click();

		String alertText = driver.findElement(By.className("android.widget.TextView")).getText();
		// String alertText =
		// driver.findElement(By.id("android:id/alertTitle")).getText();
		assertEquals(alertText, "WiFi settings");

		// copy paste: copy to clipboard and paste to textfield
		driver.setClipboardText("Swapnil");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));  // Pressing key on device keyboard
		driver.findElement(By.id("android:id/button1")).click();
		
		// Press keys on device keyboard : KeyEvent is class created by appium to handle this type of action
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
