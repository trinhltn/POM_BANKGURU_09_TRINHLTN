package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Account_Level_02_ApplyAbstractPage {
	WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	AbstractPage abstractPage;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  abstractPage = new AbstractPage();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
	  
	  email = "trinh"+randomNumber()+"@gmail.com";
	  
  }
  @Test
  public void TC_01_RegisterToSystem() {
	  Assert.assertTrue(abstractPage.elementIsDisplayed(driver, "//form[@name='frmLogin']"));
	  loginPageUrl = abstractPage.getCurrentPageUrl(driver);
	  abstractPage.clickToElement(driver, "//a[text()='here']");
	  Assert.assertTrue(abstractPage.elementIsDisplayed(driver, "//input[@name='emailid']"));
	  
	  abstractPage.senkeyToElement(driver, "//input[@name='emailid']", email);

	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  
	  userIDInfor = abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");

	  passwordInfor = abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	  System.out.println(userIDInfor +" and "+ passwordInfor);
	  
  }
  
  @Test
  public void TC_02_Login() {
	  abstractPage.openAnyUrl(driver, loginPageUrl);
	  Assert.assertTrue(abstractPage.elementIsDisplayed(driver, "//form[@name='frmLogin']"));
	  abstractPage.senkeyToElement(driver, "//input[@name='uid']", userIDInfor);
	  abstractPage.senkeyToElement(driver, "//input[@name='password']", passwordInfor);
	  
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  
	  Assert.assertTrue(abstractPage.elementIsDisplayed(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));
	  
	  Assert.assertTrue(abstractPage.elementIsDisplayed(driver, "//td[text()='Manger Id : "+userIDInfor+"']"));
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
