package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	ExcelUtility excel;

	@DataProvider(name = "invalidLogin")
	public Object[][] methodData1() {
		return new Object[][] { { "admin1", "admin" }, { "ad", "admin" }, { "watches", "admin" } };
	}

	@DataProvider(name = "deliveryBoy")
	public Object[][] deliveryBoyData() {
		excel = new ExcelUtility();
		excel.setExcelFile("DeliveryBoyData", "PalaLocation");
		Object data[][] = excel.getMultidimentionaldata(3, 6);
		return data;
	}
	
}