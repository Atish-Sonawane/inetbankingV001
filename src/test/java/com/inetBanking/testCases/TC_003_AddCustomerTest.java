package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.AddCustomerPage;
import com.inetBanking.pageObject.LoginPage;

public class TC_003_AddCustomerTest extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		Thread.sleep(3000);

		logger.info("providing customer details....");

		addcust.custName("Tester");
		addcust.custGender("male");
		addcust.custDob("11", "11", "1999");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("pune");
		addcust.custState("MH");
		addcust.custPinno("422334");
		addcust.custTelephoneno("1231231234");

		String email = randomString() + "@gmail.com";
		addcust.custEmailID(email);
		Thread.sleep(3000);
		addcust.custPassword("Test123");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}

}
