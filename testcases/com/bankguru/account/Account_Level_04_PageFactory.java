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
import pageFactory.LoginPageFactory;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Account_Level_04_PageFactory {
	WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	LoginPageFactory loginPF;
	
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
	  loginPF = new LoginPageFactory(driver);
	  Assert.assertTrue(loginPF.isLoginFormDisplayed());
	  loginPageUrl = loginPF.getLoginPageUrl();
	  loginPF.clickToHereLink();
	  
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
