package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DeleteAccountPageObject extends AbstractPage{
	public WebDriver driver;

	public DeleteAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
