package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class WithdrawalPageObject extends AbstractPage{
	public WebDriver driver;

	public WithdrawalPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
