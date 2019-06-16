package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class EditAccountPageObject extends AbstractPage{
	public WebDriver driver;

	public EditAccountPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
