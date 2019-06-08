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

public class Account_Level_11_ShareClassState_CloseBrowser_WebDriverManager extends AbstractTest {
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
	public void TC_02_Login() {
		log.info("Login - Step 02: Verify Login form display");
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		log.info("Login - Step 03: Input to UserID textbox and Password textbox");
		loginPage.inputToUserIDTextbox(Account_Common_01_RegisterToSystem.USER_ID_INFO);
		loginPage.inputToPasswordTextbox(Account_Common_01_RegisterToSystem.PASSWORD_INFO);
		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		log.info("Login - Step 05: Verify WelcomeMsg display");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		log.info("Login - Step 07: Verify userID display");
		Assert.assertTrue(homePage.isUserIDDisplayed(Account_Common_01_RegisterToSystem.USER_ID_INFO));

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
