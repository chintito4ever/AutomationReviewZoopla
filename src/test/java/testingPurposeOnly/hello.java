package testingPurposeOnly;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hello {

	@Test
	public void hihello() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Number of links availabile in this website: " + links.size());

		for (WebElement link : links) {

			// System.out.println(link.getText());

			System.out.println(link.getAttribute("href"));
		}

		driver.quit();

	}

}
