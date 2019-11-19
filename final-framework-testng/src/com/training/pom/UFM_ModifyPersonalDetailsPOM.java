package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UFM_ModifyPersonalDetailsPOM {

	
	private WebDriver driver; 
	
	public UFM_ModifyPersonalDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
			}
	
		
	
	@FindBy(linkText="Edit Account")
	private WebElement Editaccount; 
	
	@FindBy(name="firstname")
	private WebElement fname;
	

	@FindBy(name="lastname")
	private WebElement lname;
	

	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="telephone")
	private WebElement phone;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement Continue;

	
	public void editacc()
	{
	
	this.Editaccount.click();
	
	}

   public void Modifypersonaldetails(String fname,String lname,String email,String phone) throws InterruptedException
   {
	   
	   this.fname.clear();
	   this.fname.sendKeys(fname);
	   this.lname.clear();
	   this.lname.sendKeys(lname);
	   this.email.clear();
	   this.email.sendKeys(email);
	   this.phone.clear();
	   this.phone.sendKeys(phone);
	      
   }
   
   public void clickcontinue()
   {
	this.Continue.click();   
   
   }
}

