package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_Level_06_MultiBrowsers_ParallelTesting extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);

		driver.get("http://demo.guru99.com/v4/");

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

		loginPage = homePage.clickToLogOutLink();
		Assert.assertTrue(loginPage.isLoginFormDisplayed());

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
