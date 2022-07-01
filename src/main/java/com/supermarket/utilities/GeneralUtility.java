package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.supermarket.base.BaseClass;

public class GeneralUtility {

	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrlofApplication() {
		return driver.getCurrentUrl();
	}

	public String getTextofElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isExpectedTextPresent(WebElement element, String expectedText) {

		boolean status = element.getText().contains(expectedText);
		return status;
	}

	public String isExpectedTextPresents(WebElement element, String expectedText) {
		element.getText().equals(expectedText);
		return element.getText();
	}

	public void isSelectedCheckBox(WebElement element) {
		if (element.isSelected() == false) {
			element.click();
		}

	}

	public void getListofElements(String xpathExpression) {
		List<String> ListNames = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
		for (WebElement listName : elements) {
			System.out.println(listName.getText());
		}

	}

	public String getAttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String searchElementBySendKeys(String xpathExpression, String itemName) {
		Actions action = new Actions(driver);
		WebElement search = driver.findElement(By.xpath(xpathExpression));
		search.sendKeys(itemName + Keys.ENTER);
		return itemName;
	}

	public int getTableRowCount(WebElement element) {
		WebElement TogetRows = element;
		List<WebElement> TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : " + TotalRowsList.size());
		return TotalRowsList.size();
	}

	public int getTableColumnCount(String xpathExpression) {
		WebElement ToGetColumns = driver.findElement(By.xpath(xpathExpression));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of Columns in the table are: " + TotalColsList.size());
		return TotalColsList.size();
	}

	public String getCellValueFromTable(int rowCount,int columnCount, WebElement element) {
		WebElement tbl = element;
		List<WebElement> rows = tbl.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> cols = rows.get(rowCount).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {				
				String s = cols.get(columnCount).getText();
				System.out.println(s);
				return s;

			}

		}return null;
	}
}
