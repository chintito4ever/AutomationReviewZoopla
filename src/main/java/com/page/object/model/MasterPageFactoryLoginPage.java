package com.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactoryLoginPage {
	
	public MasterPageFactoryLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//*[@class='css-mx98y1-Text eczcs4p0'])[9]")
	private WebElement Login;
	@FindBy(xpath="//*[@id='input-email-address']")
	private WebElement email;
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	@FindBy(xpath="//*[@data-testid='signin-button']")
	private WebElement submit;
	
	public WebElement getLogin() {
		return Login;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmit() {
		return submit;
	}
	

}
