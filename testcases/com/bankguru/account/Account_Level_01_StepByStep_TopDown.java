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

public class Account_Level_01_StepByStep_TopDown {
	WebDriver driver;
	String loginPageUrl, userIDInfor, passwordInfor, email;
	
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
	  //step 01: check login page display
	  Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	  
	  //02: click 'here' link
	  loginPageUrl = driver.getCurrentUrl();
	  System.out.println("login page urrl "+loginPageUrl);
	  driver.findElement(By.xpath("//a[text()='here']")).click();
	  
	  //03: check register page display
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@name='emailid']")).isDisplayed());
	  
	  //04: input random email
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
	  
	  //05: click to submit button
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  //06: get user & password
	  userIDInfor = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	  passwordInfor = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	  System.out.println(userIDInfor +" and "+ passwordInfor);
	  
  }
  
  @Test
  public void TC_02_Login() {
	  //01: open login page
	  driver.get(loginPageUrl);
	  Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
	  
	  //02: input data
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userIDInfor);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passwordInfor);
	  
	  //03: click btn login
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  //04: check login page display
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed());
	  
	  //05: check userID display in Home page
	  Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Manger Id : "+userIDInfor+"']")).isDisplayed());
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
