package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class WishlistFEPageObject extends AbstractPage{
	public WebDriver driver;

	public WishlistFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
