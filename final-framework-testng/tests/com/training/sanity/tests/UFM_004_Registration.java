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
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UFM_004_Registration {
	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM RegistrationPOM;
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
		RegistrationPOM = new RegistrationPOM(driver); 
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
	public void Registration() throws Exception
	{
		RegistrationPOM.MyAccountclick();
		System.out.println("My accout clicked");
		screenShot.captureScreenShot("fisrt");
		RegistrationPOM.Registerclick();
		System.out.println("Register link clicked");
		RegistrationPOM.name("suresh", "annem");
		RegistrationPOM.email("sureshatqa@gmail.com");
		RegistrationPOM.telephone("4564565098");
		RegistrationPOM.fax("9988777989");
		RegistrationPOM.compnay("International Business Machines");
		RegistrationPOM.address("1st main raod","Pragathi layout","BENGALURU","560037");
		RegistrationPOM.state("Karnataka");
		screenShot.captureScreenShot("first");
		RegistrationPOM.password("welcome@123","welcome@123" );
		RegistrationPOM.PrivacyPolicyAndContiue();
		System.out.println("privacy policy selected");
		System.out.println("Continue button selected");			
	}

}


