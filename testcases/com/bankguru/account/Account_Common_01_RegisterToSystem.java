package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;

public class Account_Common_01_RegisterToSystem extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, email;
	public static String USER_ID_INFO, PASSWORD_INFO;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewAccountPageObject newAccountPage;
	DepositPageObject depositPage;
	FundTransferPageObject fundTransferPage;

	@Parameters({"browser", "version"})
	@BeforeTest
	public void beforeTest(String browserName, String driverVersion) {
		driver = openMultiBrowser(browserName, driverVersion);
		driver.get(Constants.TEST_SERVER_URL);
		email = "trinh" + randomNumber() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);

		log.info("Register - Step 01: Verify Login form display");
		Assert.assertTrue(loginPage.isLoginFormDisplayed());

		log.info("Register - Step 02: Get Login Page url");
		loginPageUrl = loginPage.getLoginPageUrl();

		log.info("Register - Step 03: Click to 'here' link");
		registerPage = loginPage.clickToHereLink();

		log.info("Register - Step 04: Verify Register Page display");
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());

		log.info("Register - Step 05: Input to Email Textbox");
		registerPage.inputToEmailIDTextbox(email);

		log.info("Register - Step 06: Click to Submit button");
		registerPage.clickToSubmitButton();

		log.info("Register - Step 07: Get UserID infor");
		USER_ID_INFO = registerPage.getUserIDInfor();

		log.info("Register - Step 08: Get Password infor");
		PASSWORD_INFO = registerPage.getPasswordInfor();

		closeBrowserAndDriver(driver);

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

}
