package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MiniStatementPageObject extends AbstractPage{
	public WebDriver driver;

	public MiniStatementPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
