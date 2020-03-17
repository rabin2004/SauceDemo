package com.SauceDemo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceDemoAutomation.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath ="//div[@class='product_label']")
	WebElement productsLabel;
	
	@FindBy(xpath ="//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")
	WebElement BoltTShirtAddToCart;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button")
	WebElement BoltTShirtRemove;
	
	@FindBy(xpath ="//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button")
	WebElement TShirtRedAddTOCart;
	
	@FindBy(xpath ="//*[@id=\"inventory_container\"]/div/div[6]/div[3]/button")
	WebElement TShirtRedRemove;
	
	@FindBy(id ="shopping_cart_container")
	WebElement yourCartBtn;
			
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean checkProductLabel() {
		return productsLabel.isDisplayed();	 
	}
	
	public Boolean clickBoltTShirtAddToCart() {
		BoltTShirtAddToCart.click();
		return BoltTShirtRemove.isDisplayed();
	}
	
	public Boolean clickTShirtRedAddToCart() {
		TShirtRedAddTOCart.click();
		return TShirtRedRemove.isDisplayed();
	}
	
	public YourCartPage clickyourCartBtn() {
		yourCartBtn.click();
		
		return new YourCartPage();
	}
	
}
