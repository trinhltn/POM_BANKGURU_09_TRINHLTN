package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class ShareWishlistPageObject extends AbstractPage{
	public WebDriver driver;

	public ShareWishlistPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
