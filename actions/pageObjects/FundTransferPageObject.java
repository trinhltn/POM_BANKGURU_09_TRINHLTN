package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class FundTransferPageObject extends AbstractPage{
	public WebDriver driver;

	public FundTransferPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver Fund Transfer Page = "+driver.toString());
	}

}
