package codewithswapnil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class LongPressDemo extends BaseTest {
	@Test
	public void longPressDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));

		// Long press code
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) longPress).getId(), "duration", 2000));

		longPressAction(ele); // imported from BaseTest

		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
	}
}
