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
import com.training.pom.UFM_ModifyPersonalDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_005_ModifyPersonalDetails {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
    private UFM_ModifyPersonalDetailsPOM UFMModifyPersonalDetails;
    private UFMLoginPOM UFMLogin;
	
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
		UFMModifyPersonalDetails = new UFM_ModifyPersonalDetailsPOM(driver);
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
		UFMLogin.Loginclick();
		UFMLogin.usernamepwd("sureshannem@gmail.com", "welcome@123");
		UFMLogin.login();
		screenShot.captureScreenShot("login button click");
		System.out.print("Login Method has been called and executed successfully\n");
		UFMModifyPersonalDetails.editacc();
		Thread.sleep(2000);
		screenShot.captureScreenShot(" Personal Details before Edit");
		Thread.sleep(2000);
		UFMModifyPersonalDetails.Modifypersonaldetails("suresh","A","sureshannem@gmail.com","9876543210");
		 screenShot.captureScreenShot(" Personal Details before Edit");
		 Thread.sleep(2000);
		 screenShot.captureScreenShot(" Personal Details after Edit");
		 UFMModifyPersonalDetails.clickcontinue();
		 Thread.sleep(2000);
		 screenShot.captureScreenShot("Personal Details are updated successfully");
			
			
		
			}

}


