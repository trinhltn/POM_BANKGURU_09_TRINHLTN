package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MobileLiveGuruFEPageObject extends AbstractPage{
	public WebDriver driver;

	public MobileLiveGuruFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
