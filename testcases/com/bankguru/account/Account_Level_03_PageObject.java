package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.servlet.jmx.HolderMBean;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_Level_03_PageObject {
	WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  driver.get("http://demo.guru99.com/v4/");
	  
	  email = "trinh"+randomNumber()+"@gmail.com";
	  
  }
  @Test
  public void TC_01_RegisterToSystem() {
	  loginPage = new LoginPageObject(driver);
	  Assert.assertTrue(loginPage.isLoginFormDisplayed());
	  loginPageUrl = loginPage.getLoginPageUrl();
	  loginPage.clickToHereLink();
	  registerPage = new RegisterPageObject(driver);
	  Assert.assertTrue(registerPage.isRegisterPageDisplayed());
	  registerPage.inputToEmailIDTextbox(email);
	  registerPage.clickToSubmitButton();
	  userIDInfor = registerPage.getUserIDInfor();
	  passwordInfor = registerPage.getPasswordInfor();
	  
  }
  
  @Test
  public void TC_02_Login() {
	  registerPage = new RegisterPageObject(driver);
	  registerPage.openLoginPage(loginPageUrl);
	  loginPage = new LoginPageObject(driver);
	  Assert.assertTrue(loginPage.isLoginFormDisplayed());
	  loginPage.inputToUserIDTextbox(userIDInfor);
	  loginPage.inputToPasswordTextbox(passwordInfor);
	  loginPage.clickToLoginButton();
	  homePage = new HomePageObject(driver);
	  Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	  Assert.assertTrue(homePage.isUserIDDisplayed(userIDInfor));
	  
  }
 
  public int randomNumber() {
	  Random random = new Random();
	  return random.nextInt(999999);
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
