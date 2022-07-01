package com.supermarket.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.beust.jcommander.Parameters;
import com.supermarket.utilities.PropHandler;
import com.supermarket.utilities.ScreenShot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	PropHandler prophandler;
	ScreenShot screenshot;

	public void initialise(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(WaitUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@BeforeMethod(enabled=true,alwaysRun=true)
	public void setup() {
		prophandler = new PropHandler();
		String url = prophandler.getPropertiesFileData("url");
		String browser = prophandler.getPropertiesFileData("browser");
		initialise(browser, url);

	}
	
	@org.testng.annotations.Parameters("browser")
	@BeforeMethod(enabled=false,alwaysRun=true)
	public void setUpCrossBrowser(String browser) {
	prophandler= new PropHandler();
	String url=prophandler.getPropertiesFileData("url");
	initialise(browser, url);
	}


	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult itestresult) {
		screenshot = new ScreenShot();
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			String testCaseName = itestresult.getName();
			screenshot.takeScreenShot(driver, testCaseName);
		}
		driver.close();
	}

}
