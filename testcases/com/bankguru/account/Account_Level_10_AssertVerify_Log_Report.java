package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.RegisterPageObject;

public class Account_Level_10_AssertVerify_Log_Report extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewAccountPageObject newAccountPage;
	DepositPageObject depositPage;
	FundTransferPageObject fundTransferPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		driver.get(Constants.TEST_SERVER_URL);
		email = "trinh" + randomNumber() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_RegisterToSystem() {
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
		userIDInfor = registerPage.getUserIDInfor();
		
		log.info("Register - Step 08: Get Password infor");
		passwordInfor = registerPage.getPasswordInfor();

	}
	
	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: Open Login Page url again");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		log.info("Login - Step 02: Verify Login form display");
		//Err when assertFalse
		Assert.assertFalse(loginPage.isLoginFormDisplayed());
		
		log.info("Login - Step 03: Input to UserID textbox and Password textbox");
		loginPage.inputToUserIDTextbox(userIDInfor);
		loginPage.inputToPasswordTextbox(passwordInfor);
		
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify WelcomeMsg display");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Login - Step 07: Verify userID display");
		Assert.assertTrue(homePage.isUserIDDisplayed(userIDInfor));
		
	}

	@Test
	public void TC_03_CheckAssertAndVerify() {
		log.info("Check - Step 01: Open Login Page url again");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		
		log.info("Check - Step 02: Verify Login form display");
		//Err
		verifyFalse(loginPage.isLoginFormDisplayed());
		
		log.info("Check - Step 03: Input to UserID textbox and Password textbox");
		loginPage.inputToUserIDTextbox(userIDInfor);
		loginPage.inputToPasswordTextbox(passwordInfor);
		
		log.info("Check - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Check - Step 05: Verify WelcomeMsg display");
		verifyTrue(homePage.isWelcomeMessageDisplayed());
		
		log.info("Check - Step 07: Verify userID display");
		//Err
		verifyFalse(homePage.isUserIDDisplayed(userIDInfor));
		
		
		//check neu sai xpath
		log.info("Check - Step 08: Verify XXX undisplay");
		//passed
		verifyTrue(homePage.isXXXUnDisplayed());
		//failed
		verifyFalse(homePage.isXXXUnDisplayed());
		
		
		//check neu sai xpath
		log.info("Check - Step 09: Verify XXX display");
		verifyTrue(homePage.isXXXDisplayed());
		verifyFalse(homePage.isXXXDisplayed());

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();

	}

}
