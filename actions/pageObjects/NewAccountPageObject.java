package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage{
	public WebDriver driver;

	public NewAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
