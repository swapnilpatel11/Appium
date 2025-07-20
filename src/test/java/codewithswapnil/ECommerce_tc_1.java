

package codewithswapnil;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import codewithswapnil.util.BaseTest;

public class ECommerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() {
		// enter name
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Swapnil Patel");
		
		// Radio button is hidden so going back in app or hiding keyboard
		driver.hideKeyboard();
		
		// Select Female
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
		// Choose Country
		// Click on dropdown and scroll to argentina country
		driver.findElement(By.id("android:id/text1")).click();
		scrollToText("Argentina");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// ToastMessage take attribute Name for getting text
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		
		Assert.assertEquals(toastMessage, "Please enter your name");
	
	
	}
}
