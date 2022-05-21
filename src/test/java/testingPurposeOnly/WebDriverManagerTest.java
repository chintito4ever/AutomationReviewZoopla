package testingPurposeOnly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.get("https://demo.nopcommerce.com/register");
		driver.get("https://amazon.com");

		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.navigate().to("https://facebook.com");
//
//		WebElement searchStore = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
//		System.out.println(searchStore.isDisplayed());
//		System.out.println(searchStore.isEnabled());
//
//		WebElement maleGen = driver.findElement(By.xpath("//*[@id='gender-male']"));
//		System.out.println("Male button selection status: " + maleGen.isSelected());
//
//		maleGen.click();
//		System.out.println("Male button selection status after click: " + maleGen.isSelected());
//
//		WebElement femaleGen = driver.findElement(By.xpath("//*[@id='gender-female']"));
//		System.out.println("Female button selection status: " + femaleGen.isSelected());
//
//		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}
