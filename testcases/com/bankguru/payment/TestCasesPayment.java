package com.bankguru.payment;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.Account_Common_01_RegisterToSystem;

import bankguru.AbstractPageUI;
import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.WithdrawalPageObject;

public class TestCasesPayment extends AbstractTest {
	private WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	NewAccountPageObject newAccountPage;
	EditCustomerPageObject editCustomerPage;
	EditAccountPageObject editAccountPage;
	WithdrawalPageObject withDrawalPage;

	String customerName, gender, dateOfBirth, address, city, state, pin, phone, email, password, customerID, accountID;
	String editAddress, editCity, editState, editPin, editPhone, editEmail;
	String savingAccountValue, currentAccountValue, today, initDepositValue, withDrawalAmountValue, currentBalance;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		driver.get(Constants.TEST_SERVER_URL);
		loginPage = PageFactoryManager.getLoginPage(driver);

		verifyTrue(loginPage.isLoginFormDisplayed());
		loginPage.inputToUserIDTextbox(Account_Common_01_RegisterToSystem.USER_ID_INFO);
		loginPage.inputToPasswordTextbox(Account_Common_01_RegisterToSystem.PASSWORD_INFO);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isWelcomeMessageDisplayed());

		// Init data create New Customer
		customerName = "Selenium";
		gender = "male";
		dateOfBirth = "1999-01-01";
		address = "123 Nguyen Van Linh";
		city = "Da Nang";
		state = "Hai Chau";
		pin = "123456";
		phone = "0123456789";
		email = "Selenium" + randomNumber() + "@gmail.com";
		password = "123456";

		// Init data edit Customer
		editAddress = "321 Phan Chau Trinh";
		editCity = "Ha Noi";
		editState = "Hoan Kiem";
		editPin = "090909";
		editPhone = "0909123123";
		editEmail = "Selenium" + randomNumber() + "@hotmail.com";
		
		savingAccountValue = "Savings";
		currentAccountValue = "Current";
		
		today = getToday();
		initDepositValue = "50000";
		withDrawalAmountValue = "15000";
	}

	@Test
	public void Payment_01_CreateNewCustomer() {
		log.info("Payment 01 - Step 01: Open New Customer Form");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Add New Customer"));

		log.info("Payment 01 - Step 02: Input valid data to all fields");
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "name", customerName);
		newCustomerPage.removeAttributeOfElement(driver, driver.findElement(By.xpath(AbstractPageUI.DOB)), "type");
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "dob", dateOfBirth);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "addr", address);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "city", city);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "state", state);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "pinno", pin);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "telephoneno", phone);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "emailid", email);
		newCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "password", password);
		newCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "sub");

		log.info("Payment 01 - Step 03: Verify msg 'Customer Registered Successfully!!!'");
		verifyTrue(newCustomerPage.isDynamicPageTitleDisplayed(driver, "Customer Registered Successfully!!!"));

		log.info("Payment 01 - Step 04: Verify actual data matching with expected data");
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Gender"), gender);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Address"), address);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "City"), city);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "State"), state);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Pin"), pin);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Mobile No."), phone);
		verifyEquals(newCustomerPage.getDynamicValueInTable(driver, "Email"), email);
		customerID = newCustomerPage.getDynamicValueInTable(driver, "Customer ID");
	}

	@Test
	public void Payment_02_EditCustomer() {
		log.info("Payment 02 - Step 01: Open Edit Customer Page");
		editCustomerPage = (EditCustomerPageObject) newCustomerPage.openMultiPage(driver, "Edit Customer");
		verifyTrue(editCustomerPage.isDynamicPageTitleDisplayed(driver, "Edit Customer Form"));

		log.info("Payment 02 - Step 02: Input CustomerID");
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "cusid", customerID);
		editCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "AccSubmit");

		log.info("Payment 02 - Step 03: Verify actual data matching with expected data");
		verifyTrue(editCustomerPage.isDynamicPageTitleDisplayed(driver, "Edit Customer"));

		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "name"), customerName);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "gender"), gender);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "dob"), dateOfBirth);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextArea(driver, "addr"), address);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "city"), city);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "state"), state);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "pinno"), pin);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "telephoneno"), phone);
		verifyEquals(editCustomerPage.getDynamicTextValueInTextbox(driver, "emailid"), email);

		log.info("Payment 02 - Step 04: Input data to all edit-able fields");
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "addr", editAddress);
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "city", editCity);
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "state", editState);
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "pinno", editPin);
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "telephoneno", editPhone);
		editCustomerPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "emailid", editEmail);
		editCustomerPage.clickToDynamicButtonTextBoxTextArea(driver, "sub");

		log.info("Payment 02 - Step 05: Verify msg 'Customer details updated Successfully!!!'");
		verifyTrue(editCustomerPage.isDynamicPageTitleDisplayed(driver, "Customer details updated Successfully!!!"));

		log.info("Payment 02 - Step 06: Verify actual data matching with expected data");
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Gender"), gender);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Birthdate"), dateOfBirth);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Address"), editAddress);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "City"), editCity);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "State"), editState);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Pin"), editPin);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Mobile No."), editPhone);
		verifyEquals(editCustomerPage.getDynamicValueInTable(driver, "Email"), editEmail);
	}

	@Test
	public void Payment_03_CreateNewAccountAndCheckCurrentAmount() {
		log.info("Payment 03 - Step 01: Open New Account Form");
		newAccountPage = (NewAccountPageObject) editCustomerPage.openMultiPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Add new account form"));

		log.info("Payment 03 - Step 02: Input data into form and click submit button");
		newAccountPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "cusid", customerID);
		newAccountPage.selectValueInDynamicDropdown(driver, "selaccount", savingAccountValue);
		newAccountPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "inideposit", initDepositValue);
		newAccountPage.clickToDynamicButtonTextBoxTextArea(driver, "button2");

		log.info("Payment 03 - Step 03: Verify msg 'Account Generated Successfully!!!' is displayed");
		verifyTrue(newAccountPage.isDynamicPageTitleDisplayed(driver, "Account Generated Successfully!!!"));
		
		log.info("Payment 03 - Step 04: Verify data detail");
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Customer ID"), customerID);
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Customer Name"), customerName	);
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Account Type"), savingAccountValue);
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Date of Opening"), today );
		verifyEquals(newAccountPage.getDynamicValueInTable(driver, "Current Amount"), "50000");
		accountID = newAccountPage.getDynamicValueInTable(driver, "Account ID");
		
	}

	@Test
	public void Payment_04_TransferMoneyToCurrentAccount() {
		log.info("Payment 04 - Step 01: Open Edit Account Form");
		editAccountPage = (EditAccountPageObject) newAccountPage.openMultiPage(driver, "Edit Account");
		verifyTrue(editAccountPage.isDynamicPageTitleDisplayed(driver, "Edit Account Form"));
		
		log.info("Payment 04 - Step 02: Input AccountID and click btn submit");
		editAccountPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "accountno", accountID);
		editAccountPage.clickToDynamicButtonTextBoxTextArea(driver, "AccSubmit");
		
		log.info("Payment 04 - Step 03: Verify actual data matching with expected data");
		verifyTrue(editAccountPage.isDynamicPageTitleDisplayed(driver, "Edit Account Entry Form"));
		verifyEquals(editAccountPage.getDynamicTextValueInTextbox(driver, "txtcid"), customerID);
		verifyEquals(editAccountPage.getFirstItemValueInDynamicDropdown(driver, "a_type"), savingAccountValue);
		verifyEquals(editAccountPage.getDynamicTextValueInTextbox(driver, "txtinitdep"), initDepositValue);
		
	}

	@Test
	public void Payment_05_WithdrawalMoneyInCurrentAccount() {
		log.info("Payment 05 - Step 01: Open Withdrawal Form");
		withDrawalPage = (WithdrawalPageObject) editAccountPage.openMultiPage(driver, "Withdrawal");
		verifyTrue(withDrawalPage.isDynamicPageTitleDisplayed(driver, "Amount Withdrawal Form"));
		
		log.info("Payment 05 - Step 02: Input data into all fields and click btn submit");
		withDrawalPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "accountno", accountID);
		withDrawalPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "ammount", withDrawalAmountValue);
		withDrawalPage.sendKeyToDynamicButtonTextBoxTextArea(driver, "desc", "Withdrawal");
	    withDrawalPage.clickToDynamicButtonTextBoxTextArea(driver, "AccSubmit");
		
	    log.info("Payment 05 - Step 03: Veify data matching");
	    verifyTrue(withDrawalPage.isDynamicPageTitleDisplayed(driver, "Transaction details of Withdrawal for Account "+accountID));
	    verifyEquals(withDrawalPage.getDynamicValueInTable(driver, "Account No"), accountID);
	    verifyEquals(withDrawalPage.getDynamicValueInTable(driver, "Amount Debited"), withDrawalAmountValue);
	    verifyEquals(withDrawalPage.getDynamicValueInTable(driver, "Type of Transaction"), "Withdrawal");
	    verifyEquals(withDrawalPage.getDynamicValueInTable(driver, "Description"), "Withdrawal");
	    currentBalance = Integer.parseInt(initDepositValue) - Integer.parseInt(withDrawalAmountValue)+"";
	    verifyEquals(withDrawalPage.getDynamicValueInTable(driver, "Current Balance"), currentBalance);
	    
	}

//	@Test
//	public void Payment_06_TransferMoneyToAnotherAccount() {
//	}
//
//	@Test
//	public void Payment_07_CheckCurrentAccountBalance() {
//	}
//
//	@Test
//	public void Payment_08_DeleteCurrentAccountAndVerify() {
//	}
//
//	@Test
//	public void Payment_09_DeleteCurrentCustomertAndVerify() {
//	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
