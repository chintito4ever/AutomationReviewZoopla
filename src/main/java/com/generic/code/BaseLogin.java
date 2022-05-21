package com.generic.code;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.object.model.MasterPageFactoryLoginPage;

public class BaseLogin {
	
	public static WebDriver getLogin(){
		
		//Open Browser
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//implicit wait = HTML loaded
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");
		
		MasterPageFactoryLoginPage pf = new MasterPageFactoryLoginPage(driver);
		pf.getLogin().click();
		pf.getEmail().sendKeys("demo@gmail.com");
		pf.getPassword().sendKeys("sjoerfffs");
		pf.getSubmit().click();
		return driver;
	}
	
	public static void main(String[] args) {
		
		BaseLogin.getLogin();
	}

}
