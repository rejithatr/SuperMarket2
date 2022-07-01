package com.supermarket.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.PropHandler;

public class LoginPage {
	WebDriver driver;	
	PropHandler prop = new PropHandler();
	@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//div[@class='card-body login-card-body']//p")
	private WebElement loginMsg;
	@FindBy(xpath = "//a[@class='nav-link']//img[@class='img-circle']")
	private WebElement profileImage;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement remember;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidAlert;
	@FindBy(xpath = "//button[@class='close']")
	private WebElement alertCloseButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public void loginUtility(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		//isCheckedRememberMe();
		clickOnSignInButton();
	}

	public void loginUtility() {
		String userName = prop.getPropertiesFileData("username");
		String password = prop.getPropertiesFileData("password");
		isPresentRemeber();
		loginUtility(userName, password);
	}

	public boolean isLoginInfoDisplayed(String infoMessage) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isExpectedTextPresent(loginMsg, infoMessage);
	}

	public boolean isSignInSuccess(String expectedSucessMessage) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(profileImage);
	}

	public boolean isSignInSuccess() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(profileImage);
	}

	public boolean isPresentRemeber() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(remember);
	}

	public void verifyInvalidlogin(String userName, String pass) {
		PageUtility pageutility = new PageUtility(driver);
		isPresentRemeber();
		loginUtility(userName, pass);
		isDisplayedInvalidAlert();
		pageutility.elementClick(alertCloseButton);
		
	}
	public void VerifyLoginwithNullUserName(String userName, String pass) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		isPresentRemeber();
		loginUtility(userName, pass);
		clickOnSignInButton();
	}
	public void VerifyLoginwithNullPassword(String userName, String pass) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		isPresentRemeber();
		loginUtility(userName, pass);
		clickOnSignInButton();
	}
	public boolean isDisplayedInvalidAlert() {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(invalidAlert);
	}

	public boolean isInvalidCredentialsMessageDisplayed(String expectedErrorMessage) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isExpectedTextPresent(invalidAlert, expectedErrorMessage);
	}

	public void isCheckedRememberMe() {
		GeneralUtility generalutility = new GeneralUtility(driver);	
		generalutility.isSelectedCheckBox(remember);
	}
	public boolean isUserNameCorrect(String userName) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(userNameField);
	}
	public boolean isPasswordCorrect(String passWord) {
		GeneralUtility generalutility = new GeneralUtility(driver);
		return generalutility.isElementDisplayed(passwordField);
	}
}
