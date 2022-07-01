package com.supermarket.tests;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManagePages;

public class ManagePagesTest extends BaseClass {
	LoginPage loginpage;
	SoftAssert softassert;
	ManagePages managepage;

	@Test(priority = 1)
	public void verrifytheVisibilityofManagePage() {
		loginpage = new LoginPage(driver);
		managepage = new ManagePages(driver);
		loginpage.loginUtility();
		managepage.goToViewManagePageDetails();
		String expectedInfoMessage = "List Pages";
		boolean status = managepage.isListofPagesPresent(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void verifyTheVisibilityofNewLink() {
		loginpage = new LoginPage(driver);
		managepage = new ManagePages(driver);
		loginpage.loginUtility();
		managepage.goToViewManagePageDetails();
		managepage.goToViewNewLink();
		String expectedInfoMessage = "Add Pages";
		boolean status = managepage.isAddPagesPresent(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 3)
	public void verifyTheVisibilityofSearchLink() {
		loginpage = new LoginPage(driver);
		managepage = new ManagePages(driver);
		loginpage.loginUtility();
		managepage.goToViewManagePageDetails();
		managepage.goToViewSearchLink();
		String expectedInfoMessage = "Search List Pages";
		boolean status = managepage.isSearchPagesPresent(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 4)
	public void verifyTheVisibilityofResetLink() {
		loginpage = new LoginPage(driver);
		managepage = new ManagePages(driver);
		loginpage.loginUtility();
		managepage.goToViewManagePageDetails();
		managepage.goToViewResetLink();
		String expectedInfoMessage = "Reset Pages";
		boolean status = managepage.isResetPagesPresent(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 5)
	public void editTheDetails() {
		loginpage = new LoginPage(driver);
		managepage = new ManagePages(driver);
		loginpage.loginUtility();
		managepage.goToViewManagePageDetails();
		managepage.gotoEditButton();
		String expectedInfoMessage = "Enter Page Informations";
		System.out.println(expectedInfoMessage);
		boolean status = managepage.isEditPageTextPresent(expectedInfoMessage);
		Assert.assertTrue(status);
	}
}
