package testingPurposeOnly;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttribute {
	WebDriver driver;

	@BeforeTest
	void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://admin-demo.nopcommerce.com/login");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	void tearDown() {

		driver.quit();

	}

	@Test(priority = 0)
	void enterEmail() {

		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		email.clear();
		email.sendKeys("admin@yourstore.com");
	}

	@Test(priority = 1)
	void enterPass() {

		WebElement pass = driver.findElement(By.xpath("//input[@id='Password']"));
		pass.clear();
		pass.sendKeys("admin");
	}

	@Test(priority = 2)
	void submitLogin() {
		WebElement remMe = driver.findElement(By.xpath("//input[@type='checkbox']"));

		if (remMe.isSelected() == true) {
			System.out.println("User active check box is already checked");
		} else {
			remMe.click();
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Test(priority = 3)
	void validation() {
		String title = driver.getTitle();
		System.out.println(title);

		Assert.assertEquals("Dashboard / nopCommerce administration", title);

		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

		String homeTitle = driver.getTitle();
		Assert.assertEquals("Your store. Login", homeTitle);

	}

}
