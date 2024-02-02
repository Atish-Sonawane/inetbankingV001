package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	public AddCustomerPage(WebDriver idriver) {
		this.driver = idriver;
		PageFactory.initElements(idriver, this);
	}
	
	@FindBy (xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	@FindBy (name = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy (name = "rad1") 
	@CacheLookup
	WebElement rdGender;
	
	@FindBy (name = "dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy (name = "addr")
	@CacheLookup
	WebElement txtAddresss;
	
	@FindBy (name = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy (name = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy (name = "pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy (name = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;
	
	@FindBy (name = "emailid")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (name = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custDob(String mm, String dd, String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(yy);
		txtDob.sendKeys(dd);
	}
	
	public void custAddress(String caddress) {
		txtAddresss.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custPinno(String cpinno) {
		txtPinno.sendKeys(cpinno);
	}
	
	public void custTelephoneno(String ctelephoneno) {
		txtTelephoneno.sendKeys(ctelephoneno);
	}
	
	public void custEmailID(String cemailid) {
		txtEmailId.sendKeys(cemailid);
	}
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	public void custsubmit() {
		btnSubmit.click();
	}

}
