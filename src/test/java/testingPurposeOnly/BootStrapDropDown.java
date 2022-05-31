package testingPurposeOnly;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.hdfcbank.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();

		List<WebElement> productDrp = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']"));

		for (WebElement ptype : productDrp) {
			if (ptype.getText().equals("Accounts")) {
				ptype.click();
				break;
			}
		}

		System.out.println(productDrp.size());
	}

}
