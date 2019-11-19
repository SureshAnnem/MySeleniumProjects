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
import com.training.pom.RegistrationPOM;
import com.training.pom.UFMLoginPOM;
import com.training.pom.UFMMyOrders;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_004_OrderHistory {
	

	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM RegistrationPOM;
	private static Properties properties;
	private ScreenShot screenShot;
    private UFMLoginPOM UFMLogin;
    private UFMMyOrders MyOrders;
	
    @BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		UFMLogin = new UFMLoginPOM(driver);
		MyOrders = new UFMMyOrders(driver);
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
	public void OrderHistory() throws Exception
	
	{
		
		  
		    UFMLogin.MyAccountclick();	
			screenShot.captureScreenShot("Account menu");
			UFMLogin.Loginclick();
			screenShot.captureScreenShot("login menu selected");
			UFMLogin.usernamepwd("sureshatqa@gmail.com", "welcome@123");
			screenShot.captureScreenShot("username and pwd are entered");
			UFMLogin.login();
			screenShot.captureScreenShot("login button click");
			System.out.print("Login Method has been called and executed successfully\n");	
			MyOrders.viewOrderhisotry();
			Thread.sleep(2000);	
			screenShot.captureScreenShot(" Order History Page");
			Thread.sleep(2000);	
			MyOrders.viewOrderdetails();
			screenShot.captureScreenShot(" Order Details Page");
			
			
		
			}

}


