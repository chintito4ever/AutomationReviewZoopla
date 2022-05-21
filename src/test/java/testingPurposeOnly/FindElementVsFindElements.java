package testingPurposeOnly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementVsFindElements {

	@Test
	void testFindElement() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Scenario 1
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchBox.sendKeys("Dress");
		driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();

		// Scenario 2
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(footerLinks.size());

		for (WebElement ele : footerLinks) {
			System.out.println(ele.getText());
		}

		driver.quit();

	}

}
