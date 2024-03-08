package com.supermarket.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.BaseClass;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;


public class ManageDeliveryBoyTest extends BaseClass{
	LoginPage loginpage;
	SoftAssert softassert;
	ManageDeliveryBoyPage managedeliveryBoy;
	
	
	@Test
	public void VerifyUserIsAbleToClickTheManageDeliveryBoy()
	{
		loginpage = new LoginPage(driver);
		managedeliveryBoy = new ManageDeliveryBoyPage(driver);
		loginpage.loginUtility();
		managedeliveryBoy.goToClickDeliveryBoyLink();	
		
	}


	

}
