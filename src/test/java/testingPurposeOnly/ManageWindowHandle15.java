package testingPurposeOnly;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageWindowHandle15 {

	@Test
	public void getWindowHandle() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");

//		String windowID = driver.getWindowHandle();
//		System.out.println(windowID);
		// CDwindow-A73933CD62DFD4828EEB8645EDE0AAF9
		// CDwindow-CF6A2F075FC34FF9B2565A8FFB0F44B3
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		Set<String> windowIDs = driver.getWindowHandles();

//		Iterator<String> it = windowIDs.iterator();
//
//		String parentID = it.next();
//		String childID = it.next();
//
//		driver.switchTo().window(parentID);
//		System.out.println("Parent window title: " + driver.getTitle());
//
//		Thread.sleep(3000);
//		driver.switchTo().window(childID);
//		System.out.println("Child window title: " + driver.getTitle());
		// driver.quit();

		for (String winid : windowIDs) {

			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}
		driver.close();

	}

}
