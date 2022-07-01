package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.PropHandler;

public class ManagePages {

	WebDriver driver;
	PropHandler prop = new PropHandler();
	GeneralUtility generalutility;
	PageUtility pageUtility;

	@FindBy(xpath = "(//a[@class='small-box-footer' and text()='More info '])[1]")
	private WebElement moreInfoLink;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement ListPages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newLink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchLink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetLink;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement addPageLink;
	@FindBy(xpath = "(//h4[@class='card-title'])[1]")
	private WebElement searchPageTest;
	@FindBy(xpath = "(//h4[@class='card-title'])[1]")
	private WebElement resetPageText;
	@FindBy(xpath = "//tr[1]//td[5][1]")
	private WebElement editButton;
	@FindBy(xpath = "//div//h3[@class='card-title']")
	private WebElement editPageText;

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToViewManagePageDetails() {
		moreInfoLink.click();
	}

	public boolean isListofPagesPresent(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(ListPages, expectedInfoMessage);
	}

	public void goToViewNewLink() {
		newLink.click();
	}

	public boolean isAddPagesPresent(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(addPageLink, expectedInfoMessage);
	}

	public void goToViewSearchLink() {
		searchLink.click();
	}

	public boolean isSearchPagesPresent(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(searchPageTest, expectedInfoMessage);
	}

	public void goToViewResetLink() {
		resetLink.click();
	}

	public boolean isResetPagesPresent(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(resetPageText, expectedInfoMessage);
	}

	public void gotoEditButton() {
		pageUtility = new PageUtility(driver);
		pageUtility.forMouseClick(editButton);
	}

	public boolean isEditPageTextPresent(String expectedInfoMessage) {
		generalutility = new GeneralUtility(driver);
		System.out.println(expectedInfoMessage);
		return generalutility.isExpectedTextPresent(editPageText, expectedInfoMessage);
	}

}
