package codewithswapnil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class Gestures extends BaseTest {
	@Test
	public void longPressDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		// Long press code
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) longPress).getId(), "duration", 2000));
		
		longPressAction(ele);  //imported from BaseTest
		
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		
		
	}
	
	@Test
	public void scrollDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// where to scroll is known prior
		// UIAutomator method for scrolling	(simple way to scrolling up to element) other method requires coordinates which is
		// we put element in scrollIntoView to look for scrolling from end to end
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		// when no knowledge which element need to target then use this method for scrolling
		// use while loop to keep scrolling until false following code is for scrolling until end of page
//		boolean canScrollMore;
//		do {
//		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "down",
//		    "percent", 3.0
//		));
//		} while(canScrollMore);
		
	//	scrollToEndAction(); calling this method from BaseTest
	
	
	}
	
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
