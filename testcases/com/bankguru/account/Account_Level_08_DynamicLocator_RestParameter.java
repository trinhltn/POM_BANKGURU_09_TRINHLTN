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

public class Account_Level_08_DynamicLocator_RestParameter extends AbstractTest {
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
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();
		Assert.assertTrue(registerPage.isRegisterPageDisplayed());
		registerPage.inputToEmailIDTextbox(email);
		registerPage.clickToSubmitButton();
		userIDInfor = registerPage.getUserIDInfor();
		passwordInfor = registerPage.getPasswordInfor();

	}

	@Test
	public void TC_02_Login() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(userIDInfor);
		loginPage.inputToPasswordTextbox(passwordInfor);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		Assert.assertTrue(homePage.isUserIDDisplayed(userIDInfor));

	}
	
	@Test
	public void TC_03_OpenMultiPage() {
		// Home page -> new account page
		newAccountPage = (NewAccountPageObject) homePage.openMultiPage(driver, "New Account");
		
		// new account -> deposit
		depositPage = (DepositPageObject) newAccountPage.openMultiPage(driver, "Deposit");
		
		// deposit -> fund transfer
		fundTransferPage = (FundTransferPageObject) depositPage.openMultiPage(driver, "Fund Transfer");
		
		// fund transfer -> home page
		homePage = (HomePageObject) fundTransferPage.openMultiPage(driver, "Manager");
		
	}

	@Test
	public void TC_04_OpenMultiPages() {
		// Home page -> new account page
		homePage.openMultiPages(driver, "New Account");
		newAccountPage = PageFactoryManager.getNewAccoutPage(driver);

		// new account -> deposit
		newAccountPage.openMultiPages(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);

		// deposit -> fund transfer
		depositPage.openMultiPages(driver, "Fund Transfer");
		fundTransferPage = PageFactoryManager.getFundTransferPage(driver);

		// fund transfer -> home page
		fundTransferPage.openMultiPages(driver, "Manager");
		homePage = PageFactoryManager.getHomePage(driver);

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
