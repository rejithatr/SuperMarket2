package com.supermarket.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ResponseCodeGetter;

public class HomeTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;

	@Test(priority = 1)
	public void displyTilesList() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		homepage = new HomePage(driver);
		homepage.getAlltheTilesFromHomPage();
	}

	@Test(priority = 2)
	public void verifyManagePageisAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Pages";
		boolean status = homepage.isPresentManagePage(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 3)
	public void verifyAdminUsersisAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Admin Users";
		boolean status = homepage.isPresentAdminUsers(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 4)
	public void verifyCategoryIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Category";
		boolean status = homepage.isPresentCategory(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 5)
	public void verifyManageProductIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Category";
		boolean status = homepage.isPresentManageProduct(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 6)
	public void verifyManageOfferCodeIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Offer Code";
		boolean status = homepage.isPresentManageOfferCode(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 7)
	public void verifyManageSliderIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Slider";
		boolean status = homepage.isPresentManageSlider(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 8)
	public void verifyManageUsersIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Users";
		boolean status = homepage.isPresentManageUsers(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 9)
	public void verifyManageOrdersIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Orders";
		boolean status = homepage.isPresentManageOrders(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 10)
	public void verifyMobileSliderIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Mobile Slider";
		boolean status = homepage.isPresentMobileSlider(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 11)
	public void verifyManageNewsIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage News";
		boolean status = homepage.isPresentManageNews(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 12, groups = "regression")
	public void verifyManageExpenseIsAvailable() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.loginUtility();
		String expectedInfoMessage = "Manage Expense";
		boolean status = homepage.isPresentManageExpense(expectedInfoMessage);
		Assert.assertTrue(status);
	}

	@Test(priority = 13, groups = "regression")
	public void verifyIsProfileImageBroken() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		ResponseCodeGetter response = new ResponseCodeGetter();
		loginpage.loginUtility();
		String url = homepage.getHrefOfAdminUsers("href");
		System.out.println(url);
		int resposeCode = response.getResponseCode(url);
		System.out.println(resposeCode);
		if (resposeCode >= 400) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
}
