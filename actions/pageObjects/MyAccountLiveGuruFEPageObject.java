package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MyAccountLiveGuruFEPageObject extends AbstractPage{
	public WebDriver driver;

	public MyAccountLiveGuruFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
