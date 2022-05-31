package testingPurposeOnly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown10 {

	@Test
	public void jQuery() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		driver.findElement(By.id("justAnInputBox")).click();

		selectChoiceValues(driver, "all");

//		System.out.println(driver.getTitle());

		driver.quit();

	}

	public static void selectChoiceValues(WebDriver driver, String... value) {

		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement item : choiceList) {
				String text = item.getText();

				for (String val : value) {

					if (text.equals(val)) {
						item.click();
						break;
					}
				}

			}
		} else {

			try {
				for (WebElement item : choiceList) {

					item.click();
				}

			} catch (Exception e) {

			}
		}
	}

}
