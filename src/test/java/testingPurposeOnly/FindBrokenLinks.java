package testingPurposeOnly;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {

	@Test
	void findDeadLinks() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/test/newtours/");

		// Thread.sleep(3000);

		System.out.println(driver.getTitle());

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");

			URL link = new URL(url);

			// Create a connection using url object 'link
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			Thread.sleep(2000);
			// Establish connection
			httpConn.connect();

			int resCode = httpConn.getResponseCode();

			if (resCode >= 400) {
				System.out.println(url + " - " + " is a broken link");
			} else {
				System.out.println(url + " - " + " is a valid link");
			}
		}

		driver.quit();

	}

}
