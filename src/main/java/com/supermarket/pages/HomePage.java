package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PropHandler;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalutility;
	PropHandler prop = new PropHandler();
	@FindBy(xpath = "//div[@class='row']")
	private WebElement tileList;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Pages']")
	private WebElement managePage;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Admin Users']")
	private WebElement adminUsers;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Category']")
	private WebElement category;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Product']")
	private WebElement manageProduct;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Offer Code']")
	private WebElement manageOfferCode;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage COD']")
	private WebElement manageCOD;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Slider']")
	private WebElement manageSlider;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Delivery Boy']")
	private WebElement managDeliveryBoy;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Users']")
	private WebElement manageUsers;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Orders']")
	private WebElement manageOrders;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Location']")
	private WebElement ManageLocation;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Mobile Slider']")
	private WebElement MobileSlider;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage News']")
	private WebElement ManageNews;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Expense']")
	private WebElement ManageExpense;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getAlltheTilesFromHomPage() {
		generalutility = new GeneralUtility(driver);
		String xpathExpression = "//div[@class='row']";
		generalutility.getListofElements(xpathExpression);

	}

	public boolean isPresentManagePage(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(managePage, expectedInfoMessage);
	}

	public boolean isPresentCategory(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(category, expectedInfoMessage);
	}

	public boolean isPresentAdminUsers(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(adminUsers, expectedInfoMessage);
	}

	public boolean isPresentManageProduct(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageProduct, expectedInfoMessage);
	}

	public boolean isPresentManageCOD(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageCOD, expectedInfoMessage);
	}

	public boolean isPresentManageOfferCode(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageOfferCode, expectedInfoMessage);
	}

	public boolean isPresentManageSlider(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageSlider, expectedInfoMessage);
	}

	public boolean isPresentManageUsers(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageUsers, expectedInfoMessage);
	}

	public boolean isPresentManageOrders(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageOrders, expectedInfoMessage);
	}

	public boolean isPresentManageLocation(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(manageOrders, expectedInfoMessage);
	}
	public boolean isPresentMobileSlider(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(MobileSlider, expectedInfoMessage);
	}
	public boolean isPresentManageNews(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(ManageNews, expectedInfoMessage);
	}
	
	public boolean isPresentManageExpense(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(ManageExpense
				, expectedInfoMessage);
	}
	public String getHrefOfAdminUsers(String attributeValue) {
		generalutility = new GeneralUtility(driver);	
		return generalutility.getAttributeValue(adminUsers,attributeValue); 
	}


}
