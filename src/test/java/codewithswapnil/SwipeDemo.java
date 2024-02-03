package codewithswapnil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest{
	
	@Test
	public void swipeDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		// focusable is true when selected first image
		WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		
		// Swipe: if we have element to swipe we give element id and if we dont have element to swipe then we give coordinates
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//		    "elementId",((RemoteWebElement)firstImage).getId(),
//		    "direction", "left",
//		    "percent", 0.75
//		));
		
		swipeAction(firstImage,"left", 0.35); //calling it from BasTest
		
		// when swipe is done focusable will be false
		Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
	}

}
