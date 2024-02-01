package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_001_LoginTest extends BaseClass  {
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("************* URL is open ***************");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		
		logger.info("**** ******* Enter username and password **************");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("************ Login Test pass **************");
		}else{
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("********* Login Test fail **************");
		
		}
		
	}

}
