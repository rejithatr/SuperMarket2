package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.ScreenShot;

public class LoginTest extends BaseClass {
	LoginPage loginpage;
	SoftAssert softassert;

	@Test(priority = 1,groups= {"regression","smoke"})
	public void VerifyLoginSuccessMessage() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String expectedSucessMessage = "Admin";
		boolean succesStatus = loginpage.isSignInSuccess(expectedSucessMessage);
		System.out.println();
		Assert.assertTrue(succesStatus);
	}

	@Test(priority = 2,groups="regression")
	public void VerifyLoginInfoMessage() {
		loginpage = new LoginPage(driver);
		String expectedInfoMessage = "Sign in to start your session";
		boolean status = loginpage.isLoginInfoDisplayed(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 3,groups="sanity")
	public void VerifySuccessLogin() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		boolean status = loginpage.isSignInSuccess();
		Assert.assertTrue(status);
	}

	@Test(priority = 4,groups="sanity")
	public void VerifyInvalidLogin() {
		loginpage = new LoginPage(driver);
		loginpage.verifyInvalidlogin("adqqm", "xyz");
		boolean status = loginpage.isUserNameCorrect("adqqm");
		Assert.assertTrue(status);
		boolean statusPass = loginpage.isPasswordCorrect("xyz");
		Assert.assertTrue(statusPass);
	}

	@Test(priority = 5,groups="regression")
	public void VerifyLoginwithNullUserName() {
		loginpage = new LoginPage(driver);
		loginpage.VerifyLoginwithNullUserName("", "xyz");
		String expectedUserName = "";
		boolean status = loginpage.isUserNameCorrect(expectedUserName);
		Assert.assertTrue(status);
		String expectedPassword = "xyz";
		boolean statusPass = loginpage.isPasswordCorrect(expectedPassword);
		Assert.assertTrue(statusPass);
	}

	@Test(priority = 6,groups="regression")
	public void verifyExcelData() {
		ExcelUtility excel = new ExcelUtility();
		excel.setExcelFile("Sample", "UserDetails");
		String data = excel.getCellData(1, 0);
		System.out.println(data);
	}

	@Test(dataProvider = "invalidLogin", dataProviderClass = DataProviders.class, priority = 7)
	public void invalidLoginDataProvider(String username, String password) {

		loginpage = new LoginPage(driver);
		loginpage.loginUtility(username, password);
		String expectedErrorMessage = "Invalid Username/Password";
		boolean status = loginpage.isInvalidCredentialsMessageDisplayed(expectedErrorMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 8,groups="regression")
	public void VerifyLoginwithInvalidUserNameUsingSpace() {
		loginpage = new LoginPage(driver);
		loginpage.VerifyLoginwithNullPassword(" ", "B");
		String expectedUserName = "B";
		boolean status = loginpage.isUserNameCorrect(expectedUserName);
		Assert.assertTrue(status);
		String expectedPassword = " ";
		boolean statusPass = loginpage.isPasswordCorrect(expectedPassword);
		Assert.assertTrue(statusPass);
		boolean invalidMsgStatus = loginpage.isDisplayedInvalidAlert();
		Assert.assertTrue(invalidMsgStatus);

	}

	@Test(priority = 9)
	public void VerifyLoginwithInvalidPasswordUsingSpace() {
		loginpage = new LoginPage(driver);
		loginpage.VerifyLoginwithNullPassword("B", " ");
		String expectedUserName = "B";
		boolean status = loginpage.isUserNameCorrect(expectedUserName);
		Assert.assertTrue(status);
		String expectedPassword = " ";
		boolean statusPass = loginpage.isPasswordCorrect(expectedPassword);
		Assert.assertTrue(statusPass);
		boolean invalidMsgStatus = loginpage.isDisplayedInvalidAlert();
		Assert.assertTrue(invalidMsgStatus);

	}

	@Test(priority = 10)
	public void VerifyLoginwithInvalidUserNameandPasswordUsingSpace() {
		loginpage = new LoginPage(driver);
		loginpage.VerifyLoginwithNullPassword(" ", " ");
		String expectedUserName = " ";
		boolean status = loginpage.isUserNameCorrect(expectedUserName);
		Assert.assertTrue(status);
		String expectedPassword = " ";
		boolean statusPass = loginpage.isPasswordCorrect(expectedPassword);
		Assert.assertTrue(statusPass);
		boolean invalidMsgStatus = loginpage.isDisplayedInvalidAlert();
		Assert.assertTrue(invalidMsgStatus);

	}

}
