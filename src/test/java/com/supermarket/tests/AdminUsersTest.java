package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.GeneralUtility;

public class AdminUsersTest extends BaseClass {
	private static final String String = null;
	LoginPage loginpage;
	AdminUsersPage adminuserpage;
	GeneralUtility generalutility;

	@Test(priority = 1)
	public void verifyAdminUserisAvailable() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminuserpage.clickOnMoreInfoLink();
		String expectedInfoMessage = "Admin Users";
		boolean status = adminuserpage.isPresentAdminUserPage(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void verifyTheNumberofTableRowAndColumnCount() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminuserpage.clickOnMoreInfoLink();
		adminuserpage.getTableRowCount();
		adminuserpage.getTableColumnCount();
	}
	@Test(priority = 3)
	public void verifyTheRowCountIsCorrect() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminuserpage.clickOnMoreInfoLink();
		adminuserpage.getTableRowCount();
		int expected = 41;
		int actual = adminuserpage.isPresentRowCount(expected);	
		Assert.assertEquals(actual, expected);
		}
	@Test(priority = 4)
	public void verifyTheColumnCountIsCorrect() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminuserpage.clickOnMoreInfoLink();
		adminuserpage.getTableColumnCount();
		int expected = 5;
		int actual = adminuserpage.isPresentColumnCount(expected);	
		Assert.assertEquals(actual, expected);
		}
	@Test(priority = 5)
	public void verifyTheElementIsPresent() {
		loginpage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminuserpage.clickOnMoreInfoLink();
		int rowCount=9;
		int columnCount=0;		
		adminuserpage.isPresentTheGivenTextInAdminUserTable(rowCount,columnCount);
		
		}
}