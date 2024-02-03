package codewithswapnil;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class Assignment1 extends BaseTest{
	
	@Test
	public void alertDialogs() {
		// 1)
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		String headerTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(headerTitle, "Header title");
		driver.findElement(By.id("android:id/button2")).click();
		
		// 2)
		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Command one\"]")).click();
		
		String listDialog = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]")).getText();
		Assert.assertEquals(listDialog, "You selected: 0 , Command one");
		 
	}
}
