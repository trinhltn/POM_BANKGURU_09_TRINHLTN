package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CustomisedStatementPageObject extends AbstractPage{
	public WebDriver driver;

	public CustomisedStatementPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
