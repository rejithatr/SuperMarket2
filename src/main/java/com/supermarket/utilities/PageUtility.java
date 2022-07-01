package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void clearTextfield(WebElement element) {
		element.clear();
	}

	public void selectBy_Index(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectBy_Value(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void accept_Alert() {
		driver.switchTo().alert().accept();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public boolean checkStatus(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void scroll_And_Click(WebElement element) {
		int y = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while (checkStatus(element)) {
			js.executeScript("window.scrollBy( 0 ," + y + ")");
			y = y + 50;
		}

	}

	public void forMouseClick(WebElement element) {
		Actions mouseAction = new Actions(driver);
		mouseAction.click(element).build().perform();
	}

	public void robotExample() throws AWTException {
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
	}

	public void alertAccept(WebElement element) {
		element.click();
		driver.switchTo().alert().accept();
	}

	public void alertCancel(WebElement element) {
		element.click();
		driver.switchTo().alert().dismiss();
	}

	public void TextofAlert(WebElement element) {
		element.click();
		String msg = driver.switchTo().alert().getText();
		System.out.print(msg);
	}

	public void elementClick(WebElement element) {
		element.click();
	}

	public void scrollTheElementToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element); // move to particular element
		element.click();
	}

}
