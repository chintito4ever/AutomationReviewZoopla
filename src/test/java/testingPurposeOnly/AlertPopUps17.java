package testingPurposeOnly;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUps17 {

	public static void main(String[] args) {

		// Use these options to disable notification popups
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Use Username:Password@URL to handle popup authentication credentials
		// driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

		driver.get("https://www.redbus.in/");

	}

}
