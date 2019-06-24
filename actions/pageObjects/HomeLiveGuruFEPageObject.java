package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomeLiveGuruFEPageObject extends AbstractPage{
	public WebDriver driver;

	public HomeLiveGuruFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
