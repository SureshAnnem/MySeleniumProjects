package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPOM {
	
private WebDriver driver; 
	
	public RegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myaccount; 
	
	@FindBy(linkText="Register")
	private WebElement Register;
	
	@FindBy(name="firstname")
	private WebElement fname; 
	
	@FindBy(name="lastname")
	private WebElement lname; 
	
	@FindBy(id="input-email")
	private WebElement email; 
	
	@FindBy(name="telephone")
	private WebElement phone; 
	
	@FindBy(id="input-fax")
	private WebElement fax; 
	
	@FindBy(id="input-company")
	private WebElement company; 
	
	
	@FindBy(id="input-address-1")
	private WebElement address1; 
	
	@FindBy(id="input-address-2")
	private WebElement address2; 
	
	@FindBy(id="input-city")
	private WebElement city; 
	
	@FindBy(id="input-postcode")
	private WebElement postcode; 
	
	@FindBy(xpath="//select[@id='input-zone']")
	private WebElement state;
	
	@FindBy(id="input-password")
	private WebElement pwd; 
	
	@FindBy(id="input-confirm")
	private WebElement confirmpwd; 
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement terms; 

	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Continue; 
	
	public void MyAccountclick() 
	{
		this.myaccount.click();
		
	}
	
	public void Registerclick() 
	{
		this.Register.click();
		
	}
		
	public void name(String fname,String lname) 
	{
		this.fname.sendKeys(fname);
		this.lname.sendKeys(lname);
		
	}


	public void email(String email) 
	{
		this.email.sendKeys(email);
		
	}

	public void telephone(String phone) 
	{
		this.phone.sendKeys(phone);
		
	}

	public void fax(String fax) 
	{
		this.fax.sendKeys(fax);
		
	}

	
	public void compnay(String company)
	{
		
		this.company.sendKeys(company); 
		 
	}

	
	public void address(String address1,String address2,String city,String postcode)
	{
		
		this.address1.sendKeys(address1); 
		this.address2.sendKeys(address2); 
		this.city.sendKeys(city); 
		this.postcode.sendKeys(postcode);
	}
	
	public void state(String Value)
	{
		Select st = new Select(state);
		st.selectByVisibleText(Value);
	}
	
	
	public void password(String pwd,String confirmpwd)
	{
		this.pwd.sendKeys(pwd);
		this.confirmpwd.sendKeys(confirmpwd);
	}
	
	public void PrivacyPolicyAndContiue() 
	{
		terms.click();
		Continue.click();
					
}
	
}
	

