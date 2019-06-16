package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;

public class Account_Level_12_DynamicPageElement extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		driver.get(Constants.TEST_SERVER_URL);
		email = "trinh" + randomNumber() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
		verifyTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(Account_Common_01_RegisterToSystem.USER_ID_INFO);
		loginPage.inputToPasswordTextbox(Account_Common_01_RegisterToSystem.PASSWORD_INFO);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());
	}
	
	@Test
	public void TC_01_ValidateErrorMessageAtNewCustomerForm() {
		log.info("Validate New Customer - Step 01: Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Add New Customer"));
		
		log.info("Validate New Customer - Step 02: Click to all fields on New Customer Form");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "name");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "dob");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "addr");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "city");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "state");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "pinno");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "telephoneno");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "emailid");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "password");
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "emailid");
		
		log.info("Validate New Customer - Step 03: Verify all fields are dislay error message");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "Customer Name"), "Customer name must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "Date of Birth"), "Date Field must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "Address"), "Address Field must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "City"), "City Field must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "State"), "State must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "PIN"), "PIN Code must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "Mobile Number"), "Mobile no must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "E-mail"), "Email-ID must not be blank");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "Password"), "Password must not be blank");
		
	}

	@Test
	public void TC_02_ValidateErrorMessageAtNewAccountForm() {
		log.info("Validate New Account - Step 01: Open New Account Page");
		newAccountPage = (NewAccountPageObject) newCustomerPage.openMultiPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Add new account form"));
		
		log.info("Validate New Account - Step 02: Click to all fields on New Account Form");
		newAccountPage.clickToDynamicButtonTextBoxTextArea(driver, "cusid");
		newAccountPage.clickToDynamicButtonTextBoxTextArea(driver, "inideposit");
		newAccountPage.clickToDynamicButtonTextBoxTextArea(driver, "cusid");
		
		log.info("Validate New Account - Step 03: Verify all fields are dislay error message");
		verifyEquals(newAccountPage.getDynamicErrorMessage(driver, "Customer id"), "Customer ID is required");
		verifyEquals(newAccountPage.getDynamicErrorMessage(driver, "Initial deposit"), "Initial Deposit must not be blank");
		
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
