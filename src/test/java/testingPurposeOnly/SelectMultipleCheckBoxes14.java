package testingPurposeOnly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectMultipleCheckBoxes14 {

	@Test
	public void checkBoxes() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/radio.html");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		// Select only given checkboxes
		/*
		 * for (WebElement chckbox : checkboxes) {
		 * 
		 * String checkobxname = chckbox.getAttribute("value");
		 * 
		 * if (checkobxname.equals("checkbox2") || checkobxname.equals("checkbox3")) {
		 * 
		 * chckbox.click();
		 * 
		 * Thread.sleep(3000); }
		 */

		// Select first 2 check boxes
		int totalcheckboxes = checkboxes.size();

		for (int i = 0; i < totalcheckboxes; i++) {

			if (i < 2) {

				checkboxes.get(i).click();
			}

		}
	}
}
