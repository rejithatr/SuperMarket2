package com.supermarket.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.PropHandler;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtility generalutility;
	PageUtility pageUtility;
	
	
	
	
	@FindBy(xpath = "(//p[text()='Manage Delivery Boy']")

	private WebElement deliveryBoy;
	
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public void goToClickDeliveryBoyLink() {
		
		System.out.println(deliveryBoy.getText());
		
	}
	
	
}
