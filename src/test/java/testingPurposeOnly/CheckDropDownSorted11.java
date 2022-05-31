package testingPurposeOnly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropDownSorted11 {

	@Test
	void checkDDSorted() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.twoplugs.com/newsearchserviceneed");

		WebElement drpElement = driver.findElement(By.name("category_id"));
		Select drpSelect = new Select(drpElement);

		List<WebElement> options = drpSelect.getOptions();

		ArrayList originalList = new ArrayList();
		ArrayList templist = new ArrayList();

		for (WebElement option : options) {

			originalList.add(option.getText());
			templist.add(option.getText());

		}

		System.out.println("Original list: " + originalList);
		Collections.sort(templist);
		System.out.println("Temp list after sorting: " + templist);

		if (originalList.equals(templist)) {
			System.out.println("Dropdown sorted....");
		} else {
			System.out.println("Dropdown not sorted...");
		}

		driver.close();

	}

}
