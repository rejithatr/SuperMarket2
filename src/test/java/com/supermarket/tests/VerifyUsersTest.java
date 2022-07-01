package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.VerifyUsersPage;
import com.supermarket.utilities.ExcelUtility;

public class VerifyUsersTest extends BaseClass {

	LoginPage loginpage;	
	VerifyUsersPage verifyuserspage;

	@Test(priority = 1, groups = "regression")
	public void verifyVisibilityOfUsers() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		verifyuserspage = new VerifyUsersPage(driver);
		String expectedAttribute = " nav-link";
		String actual = verifyuserspage.checkVisibilityofVerifyUsersofPage();
		Assert.assertEquals(actual, expectedAttribute);
	}

	@Test(priority = 2, groups = "regression")
	public void verifyVisibilityOfPushNotification() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		verifyuserspage = new VerifyUsersPage(driver);
		String expectedAttribute = " nav-link";
		String actual = verifyuserspage.checkVisibilityofPushNotification();
		Assert.assertEquals(actual, expectedAttribute);
	}

	@Test(priority = 3, groups = "regression")
	public void verifyPushNotification() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		verifyuserspage = new VerifyUsersPage(driver);
		verifyuserspage.clickOnPushNotification();
		verifyuserspage.getTiltleData(1, 0);
		verifyuserspage.getDescription(1, 1);
		verifyuserspage.clickOnSaveButton();
		String expected = "Message send successfully";
		boolean status = verifyuserspage.isSuccessAlertPresernt(expected);
		Assert.assertTrue(status);
	}
}
