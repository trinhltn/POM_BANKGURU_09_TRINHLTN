package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DepositPageObject extends AbstractPage{
	public WebDriver driver;

	public DepositPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver Deposit Page = "+driver.toString());
	}

}
