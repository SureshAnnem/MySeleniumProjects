package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UFMLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_004_Login {

	private WebDriver driver;
	private String baseUrl;
	private UFMLoginPOM ufmlogin ;
	private static Properties properties;
	private ScreenShot screenShot;

	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		ufmlogin = new UFMLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void logintest() 
	{
		
	ufmlogin.MyAccountclick();	
	screenShot.captureScreenShot("Account menu");
	ufmlogin.Loginclick();
	screenShot.captureScreenShot("login menu selected");
	ufmlogin.usernamepwd("sureshatqa@gmail.com", "welcome@123");
	screenShot.captureScreenShot("username and pwd are entered");
	ufmlogin.login();
	screenShot.captureScreenShot("login button clicked");
		
		}
	
}

