package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PropHandler;

public class VerifyUsersPage {
	WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtility generalutility;

	@FindBy(xpath = "//li[5]//a")
	private WebElement verifyUsersButton;
	@FindBy(xpath = "//li[7]//a")
	private WebElement pushNotificationLink;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleNotification;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement descriptionNotification;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertText;

	public VerifyUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String checkVisibilityofVerifyUsersofPage() {
		generalutility = new GeneralUtility(driver);
		String attributeValue = generalutility.getAttributeValue(verifyUsersButton, "class");
		System.out.println(attributeValue);
		return attributeValue;
	}

	public String checkVisibilityofPushNotification() {
		generalutility = new GeneralUtility(driver);
		String attributeValue = generalutility.getAttributeValue(pushNotificationLink, "class");
		System.out.println(attributeValue);
		return attributeValue;
	}

	public void clickOnPushNotification() {
		pushNotificationLink.click();
	}

	public void getTiltleData(int row, int column) {
		generalutility = new GeneralUtility(driver);
		ExcelUtility excel = new ExcelUtility();
		excel.setExcelFile("PushNotification", "Notification");
		String title = excel.getCellData(1, 0);
		titleNotification.sendKeys(title);
	}

	public void getDescription(int row, int column) {
		ExcelUtility excel = new ExcelUtility();
		excel.setExcelFile("PushNotification", "Notification");
		String Description = excel.getCellData(1, 1);
		descriptionNotification.sendKeys(Description);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public String getAlert() {
		return alertText.getText();
	}

	public boolean isSuccessAlertPresernt(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(alertText, expectedInfoMessage);
	}
}
