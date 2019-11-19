package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UFMLoginPOM {
	
private WebDriver driver; 
	
	public UFMLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myaccount; 
	
	@FindBy(linkText="Login")
	private WebElement loginmenu; 
		
	@FindBy(id="input-email")
	private WebElement emailaddress; 
	
		
	@FindBy(name="password")
	private WebElement pwd; 
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login; 
	
	public void MyAccountclick() 
	{
		this.myaccount.click();
		System.out.println("my account link clicked");
		
	}
	
	public void Loginclick() 
	{
		this.loginmenu.click();
		System.out.println("link menu clicked");
	}
		
	public void usernamepwd(String emailaddress,String pwd) 
	{
		this.emailaddress.sendKeys(emailaddress);
		this.pwd.sendKeys(pwd);
		System.out.println("user name and pwd entered successfully");
	}

		public void login() 
	{
		login.click();
		System.out.println("login button clicked successfully");
					
}
	
}
	

