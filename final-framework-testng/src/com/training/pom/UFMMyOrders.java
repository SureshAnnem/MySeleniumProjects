package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UFMMyOrders{
	private WebDriver driver; 
		
	public UFMMyOrders(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		
			}
	
		
	
	@FindBy(linkText="Order History")
	private WebElement Orderhistory; 
	
	@FindBy(xpath="//a[@data-original-title='View']")
	private WebElement view;
	
	
	public void viewOrderhisotry() {
		this.Orderhistory.click(); 
			}
	
	public void viewOrderdetails()
	{
	this.view.click();
	
	}
	
}
