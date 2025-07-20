package codewithswapnil.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

//	@BeforeMethod
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, IOException {
		// AndroidDriver class for automate Android apps
		// for IOS apps IOSDriver class
		// two arguments in AndroidDriver first argument= "url of appium server" and
		// Appium code -> Appium Server -> Mobile

		// One time setup of Appium

		// Configurations

//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\Swapn\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\data.properties");
//
//		String ipAddress = prop.getProperty("ipAddress");
//		String port = prop.getProperty("port");

		// Appium Service builder for Appium server open appium server from this code
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\Swapn\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		// which device, which version,which application for environment
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SwapnilPhone");
	//	options.setApp("C:\\Users\\Swapn\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\Swapn\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\General-Store.apk");

		// two arguments in AndroidDriver first argument= "url of appium server" and
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	// Long Press Gesture Action
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	// Custom code for scroll till end of page
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}
	
	// Scroll to Text
		public void scrollToText(String text) {
			driver.findElement(
					AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		}

	// Swipe if we have element to swipe
	public void swipeAction(WebElement ele, String direction, double percentage) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", percentage));
	}

	// Drag and Drop Method
	public void dragAndDropAction(WebElement source, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", x, "endY", y));
	}
	

	// @AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop(); // stop service
	}

}
