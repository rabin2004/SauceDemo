package com.SauceDemoAutomation.qa.test;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SauceDemo.qa.pages.HomePage;
import com.SauceDemo.qa.pages.LoginPage;
import com.SauceDemo.qa.pages.YourCartPage;
import com.SauceDemoAutomation.qa.base.TestBase;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	YourCartPage yourcartpage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();	
		loginpage = new LoginPage();
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void checkProductPageLabel() {
		Boolean productLabel =homepage.checkProductLabel();
		Assert.assertTrue(productLabel);
	}
	
	@Test(priority =2)
	public void AddTshirtToTheCart() {
		Boolean BoltTshirtRemoveBtn = homepage.clickBoltTShirtAddToCart();
		Boolean TshirtRedRemoveBtn = homepage.clickTShirtRedAddToCart();
		Assert.assertTrue(BoltTshirtRemoveBtn);
		Assert.assertTrue(TshirtRedRemoveBtn);
	}
	
	@Test(priority =3)
	public void clickYourCartBtn() {
		yourcartpage =homepage.clickyourCartBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
