package com.supermarket.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public static final long PAGE_LOAD_WAIT = 20;
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT=20;

	
	 public void waitForElementToBeClickable(String xpath) {
		 wait= new WebDriverWait(driver, EXPLICIT_WAIT);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	 }


}
