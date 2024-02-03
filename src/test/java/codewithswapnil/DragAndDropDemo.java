package codewithswapnil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class DragAndDropDemo extends BaseTest {
	
	@Test
	public void dragAndDropDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		// Source of element which we want to drop at target
		WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		// Drag and Drop code
//		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
//		    "elementId", ((RemoteWebElement) source).getId(),
//		    "endX", 619,
//		    "endY", 560
//		));
		
		dragAndDropAction(source,619,516); //calling it from BaseTest
		
		String droppedMessage = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		Assert.assertEquals(droppedMessage, "Dropped!");
		
		
	}
}
