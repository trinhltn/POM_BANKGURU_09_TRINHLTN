package com.liveguru.fe;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.HomeLiveGuruFEPageObject;
import pageObjects.MyAccountLiveGuruFEPageObject;

public class LiveGuru_FE extends AbstractTest {
	private WebDriver driver;
	HomeLiveGuruFEPageObject homeLiveGuruFEPage;
	MyAccountLiveGuruFEPageObject myAccountLiveGuruFEPage;
	String firstName, lastName, email, password;

	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeTest(String browserName, String driverVersion) {
		driver = openMultiBrowser(browserName, driverVersion);
		driver.get(Constants.LIVE_GURU_FE_SERVER_URL);
		homeLiveGuruFEPage = PageFactoryManager.getHomeLiveGuruPage(driver);

		firstName = "Trinh";
		lastName = "Le";
		email = "trinh" + randomNumber() + "@gmail.com";
		password = "123123";

	}

	@Test
	public void TC_01_LiveGuru_FE_RegisterToSystem() {
		log.info("Register 01 - Step 01: Click to ACCOUNT menu");
		homeLiveGuruFEPage.clickToAccountTab(driver);
		log.info("Register 01 - Step 02: Choose Register link");
		homeLiveGuruFEPage.clickToRegisterLink(driver);
		log.info("Register 01 - Step 03: Verify move to create account page");
		verifyTrue(homeLiveGuruFEPage.isCreateAccountPageDisplayed(driver));
		log.info("Register 01 - Step 04: Input valid data into all fields");
		homeLiveGuruFEPage.sendKeyToElementsCreateAcc(driver, "firstname", firstName);
		homeLiveGuruFEPage.sendKeyToElementsCreateAcc(driver, "lastname", lastName);
		homeLiveGuruFEPage.sendKeyToElementsCreateAcc(driver, "email_address", email);
		homeLiveGuruFEPage.sendKeyToElementsCreateAcc(driver, "password", password);
		homeLiveGuruFEPage.sendKeyToElementsCreateAcc(driver, "confirmation", password);
		log.info("Register 01 - Step 05: Click to register btn");
		homeLiveGuruFEPage.clickToRegisterBtn(driver);
		log.info("Register 01 - Step 07: Verify display msg Thank you for registering with Main Website Store.");
		verifyTrue(homeLiveGuruFEPage.isMsgRegisterSuccessfullyDisplayed(driver));
		
	}
	
	@Test
	public void TC_02_Verify_Data_After_RegisterSuccessfully() {
		log.info("Verify 02 - Step 01: Open LiveGuru99 site "); 
		driver.get(Constants.LIVE_GURU_FE_SERVER_URL);
		log.info("Verify 02 - Step 02: Open 'MY ACCOUNT' page");
//		------------------------
		homeLiveGuruFEPage.clickToMyAccountLink(driver);
		log.info("Verify 02 - Step 03: Verify display MY DASHBOARD");
		verifyTrue(myAccountLiveGuruFEPage.isTitleOfMyAccountPageDisplayed(driver));
		log.info("Verify 02 - Step 03: Open 'ACCOUNT INFORMATION' page");
		
		
		
		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
