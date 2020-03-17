package com.SauceDemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceDemoAutomation.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id ="user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath ="//input[@value='LOGIN']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String ps){
		username.sendKeys(un);
		password.sendKeys(ps);
		loginBtn.click();
		
		return new HomePage();
	} 
}
