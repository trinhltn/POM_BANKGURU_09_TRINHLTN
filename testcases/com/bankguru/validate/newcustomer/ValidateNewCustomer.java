package com.bankguru.validate.newcustomer;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.NewCustomerPageUI;
import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class ValidateNewCustomer extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		driver.get("http://demo.guru99.com/v4/");
		email = "trinh" + randomNumber() + "@gmail.com";
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	@Test
	public void TC_001_RegisterToSystem() {
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
	public void TC_002_Login() {
		loginPage = registerPage.openLoginPage(loginPageUrl);
		Assert.assertTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(userIDInfor);
		loginPage.inputToPasswordTextbox(passwordInfor);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
		Assert.assertTrue(homePage.isUserIDDisplayed(userIDInfor));
	}

	@Test
	public void TC_01_NameNotEmpty() {
		newCustomerPage = homePage.openNewCustomerPage(driver);
		newCustomerPage.clickToCustomerNameTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isCustomerNameNotEmptyDisplay());
	}

	@Test
	public void TC_02_NameNotNumeric() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCustomerName("1234");
		Assert.assertTrue(newCustomerPage.isCustomerNameNotNumericDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCustomerName("name1234");
		Assert.assertTrue(newCustomerPage.isCustomerNameNotNumericDisplay());
	}
	
	@Test
	public void TC_03_NameNotSpecialCharacters() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCustomerName("name!@#");
		Assert.assertTrue(newCustomerPage.isCustomerNameNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCustomerName("!@#");
		Assert.assertTrue(newCustomerPage.isCustomerNameNotSpecialCharactersDisplay());
	}
	
	@Test
	public void TC_04_NameNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCustomerName(" tommy");
		Assert.assertTrue(newCustomerPage.isCustomerNameNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_05_AddressNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToAddressTextArea();
		newCustomerPage.pressTABKey(NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isAddressNotEmptyDisplay());
	}
	
	@Test
	public void TC_06_AddressNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToAddress(" hanoi");
		Assert.assertTrue(newCustomerPage.isAddressNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_07_CityNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToCityTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.CITY_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isCityNotEmptyDisplay());
	}
	
	@Test
	public void TC_08_CityNotNumeric() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCity("1234");
		Assert.assertTrue(newCustomerPage.isCityNotNumericDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCity("city123");
		Assert.assertTrue(newCustomerPage.isCityNotNumericDisplay());
	}
	
	@Test
	public void TC_09_CityNotSpecialCharacters() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCity("City!@#");
		Assert.assertTrue(newCustomerPage.isCityNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCity("!@#");
		Assert.assertTrue(newCustomerPage.isCityNotSpecialCharactersDisplay());
	}
	
	@Test
	public void TC_10_CityNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToCity(" city");
		Assert.assertTrue(newCustomerPage.isCityNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_11_StateNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToStateTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.STATE_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isStateNotEmptyDisplay());
	}
	
	@Test
	public void TC_12_StateNotNumeric() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToSate("1234");
		Assert.assertTrue(newCustomerPage.isStateNotNumericDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToSate("state123");
		Assert.assertTrue(newCustomerPage.isStateNotNumericDisplay());
	}
	
	@Test
	public void TC_13_StateNotSpecialCharacters() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToSate("State!@#");
		Assert.assertTrue(newCustomerPage.isStateNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToSate("!@#");
		Assert.assertTrue(newCustomerPage.isStateNotSpecialCharactersDisplay());
	}
	
	@Test
	public void TC_14_StateNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToSate(" State");
		Assert.assertTrue(newCustomerPage.isStateNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_15_PINMustNumeric() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN("1234");
		Assert.assertTrue(newCustomerPage.isPINMust6DigitsDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN("1234PIN");
		Assert.assertTrue(newCustomerPage.isPINMustCharactersDisplay());
	}
	
	@Test
	public void TC_16_PINNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToPINTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.PIN_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isPINNotEmptyDisplay());
	}
	
	@Test
	public void TC_17_PINMust6Digits() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN("1234");
		Assert.assertTrue(newCustomerPage.isPINMust6DigitsDisplay());
	}
	
	@Test
	public void TC_18_PINNotSpecialCharacters() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN("!@#");
		Assert.assertTrue(newCustomerPage.isPINNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN("123!@#");
		Assert.assertTrue(newCustomerPage.isPINNotSpecialCharactersDisplay());
	}
	
	@Test
	public void TC_19_PINNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN(" 12312");
		Assert.assertTrue(newCustomerPage.isPINNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_20_PINNotCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPIN(" 12312");
		Assert.assertTrue(newCustomerPage.isPINNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_21_PhoneNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToPhoneTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.PHONE_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isPhoneNotEmptyDisplay());
	}
	
	@Test
	public void TC_22_PhoneNotFirstCharacterBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPhone(" 09099009");
		Assert.assertTrue(newCustomerPage.isPhoneNotFirstCharacterBlankSpaceDisplay());
	}
	
	@Test
	public void TC_23_PhoneNotBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPhone("123 123");
		Assert.assertTrue(newCustomerPage.isPhoneNotBlankSpaceDisplay());
	}
	
	@Test
	public void TC_24_PhoneNotSpecialCharacters() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPhone("886636!@12");
		Assert.assertTrue(newCustomerPage.isPhoneNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPhone("88663682!@");
		Assert.assertTrue(newCustomerPage.isPhoneNotSpecialCharactersDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToPhone("!@88662682");
		Assert.assertTrue(newCustomerPage.isPhoneNotSpecialCharactersDisplay());
	}
	
	@Test
	public void TC_25_EmailNotEmpty() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.clickToEmailTextBox();
		newCustomerPage.pressTABKey(NewCustomerPageUI.EMAIL_TEXTBOX, Keys.TAB);
		Assert.assertTrue(newCustomerPage.isEmailNotEmptyDisplay());
	}
	
	@Test
	public void TC_26_EmailInCorrect() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("guru99@gmail");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("guru99");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("Guru99@");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("guru99@gmail.");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("guru99gmail.com");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
	}

	@Test
	public void TC_27_EmailNotBlankSpace() {
		newCustomerPage.refreshPage(driver);
		newCustomerPage.sendkeyToEmail("guru99 @gmail");
		Assert.assertTrue(newCustomerPage.isEmailInCorrectDisplay());
	}
	
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
	}

}
