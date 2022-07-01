package com.supermarket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PropHandler;

public class AdminUsersPage {

	WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtility generalutility;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement adminUsersText;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	private WebElement adminMoreInfoLink;
	@FindBy(xpath = "(//tr[1]//td[3]//a//span[@class='badge bg-success'])[1]")
	private WebElement clickFirstActiveOne;
	@FindBy(xpath = "(//tr[1]//td[3]//a//span[@class='badge bg-warning'])[1]")
	private WebElement clickFirstInactiveOne;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	private WebElement alertText;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	private WebElement adminTable;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	private WebElement adminColumncount;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnMoreInfoLink() {
		adminMoreInfoLink.click();
	}

	public boolean isPresentAdminUserPage(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(adminUsersText, expectedInfoMessage);
	}

	
	public void clickFirstActiveOne() {
		clickFirstActiveOne.click();
	}
	public void clickFirstInActiveOne() {
		clickFirstInactiveOne.click();
	}

	public String getTextofActiveOne() {
		 return clickFirstActiveOne.getText();
	}
	public String getFirstInactiveOne() {
		return clickFirstInactiveOne.getText();
	}
	public boolean isPresentActiveButtonEnabled(String expectedInfoMessage) {
		return false;
	}

	public void getTableRowCount()
	{
		
		generalutility = new GeneralUtility(driver);
		generalutility.getTableRowCount(adminTable);
		
	}
	public void getTableColumnCount()
	{
		generalutility = new GeneralUtility(driver);
		generalutility.getTableColumnCount("//table[@class='table table-bordered table-hover table-sm']/tbody/tr");
	}

	public int isPresentRowCount(int expected) {
		generalutility = new GeneralUtility(driver);	
		int actul=generalutility.getTableRowCount(adminTable);
		return actul;
	}

	public int isPresentColumnCount(int expected) {
		generalutility = new GeneralUtility(driver);	
		int actul=generalutility.getTableColumnCount("//table[@class='table table-bordered table-hover table-sm']/tbody/tr");
		return actul;
	}
	public String isPresentTheGivenTextInAdminUserTable(int rowCount,int columnCount)
	{
		generalutility = new GeneralUtility(driver);	
		String text =generalutility.getCellValueFromTable(rowCount,columnCount, adminTable);
		return text;
		
	}
}
