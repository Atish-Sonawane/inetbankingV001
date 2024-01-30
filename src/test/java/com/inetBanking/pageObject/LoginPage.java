package com.inetBanking.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver idriver) {
		this.driver = idriver;
		PageFactory.initElements(idriver, this);
	}
	
	@FindBy (name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	/* ----------------------------------------------------------Syntax 2
	@FindBy (how = How.NAME, using = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	-------------------------------------------------------------Syntax 3
	By txtUserName = By.name("uid");
	*/
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy (xpath = "//a[@href= 'Logout.php']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		txtUserName.click();
	}
	public void clickLogout() {
		txtUserName.click();
	}

}
