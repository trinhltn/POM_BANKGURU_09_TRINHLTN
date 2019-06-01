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

public class Account_Level_09_CheckUndisplayed_OverideTimeout extends AbstractTest {
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

		// check userdata undisplayed
		boolean userDataStatus = homePage.isUserDataUnDisplayed();
		System.out.println("user data status = " + userDataStatus);
		Assert.assertTrue(userDataStatus);

		// check welcome message displayed
		boolean homePageStatus = homePage.isWelcomeMessageDisplayed();
		System.out.println("home page status message = " + homePageStatus);
		Assert.assertTrue(homePageStatus);

		// check login form undisplayed
		boolean loginFormStatus = (homePage.isLoginFormUnDisplayed());
		// true-> displayed
		// false-> undisplayed
		System.out.println("Login form status = " + loginFormStatus);
		Assert.assertTrue(loginFormStatus);

		Assert.assertTrue(homePage.isUserIDDisplayed(userIDInfor));

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
