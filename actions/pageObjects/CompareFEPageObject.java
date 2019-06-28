package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class CompareFEPageObject extends AbstractPage{
	public WebDriver driver;

	public CompareFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
