package testingPurposeOnly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDownn12 {

	@Test
	void AutoSuggestDD() {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.bing.com/");

		driver.findElement(By.id("sb_form_q")).sendKeys("Selenium");

		List<WebElement> searchList = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));

		System.out.println("Size of autosuggestions: " + searchList.size());

		for (WebElement listitem : searchList) {

			if (listitem.getText().contains("selenium")) {
				listitem.click();
				break;
			}
		}
	}

}
