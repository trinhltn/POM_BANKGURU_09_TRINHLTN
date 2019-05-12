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
import commons.PageFactoryManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_Level_05_PageFactoryManager_SingletonPattern {
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
	  loginPage  = registerPage.openLoginPage(loginPageUrl);
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
	  driver.quit();
	  
  }

}
