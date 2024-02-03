package codewithswapnil;

import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {

	@Test
	public void scrollDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// where to scroll is known prior
		// UIAutomator method for scrolling (simple way to scrolling up to element)
		// other method requires coordinates which is
		// we put element in scrollIntoView to look for scrolling from end to end
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

		// when no knowledge which element need to target then use this method for
		// scrolling
		// use while loop to keep scrolling until false following code is for scrolling
		// until end of page
//		boolean canScrollMore;
//		do {
//		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//		    "left", 100, "top", 100, "width", 200, "height", 200,
//		    "direction", "down",
//		    "percent", 3.0
//		));
//		} while(canScrollMore);

		// scrollToEndAction(); calling this method from BaseTest

	}

}
