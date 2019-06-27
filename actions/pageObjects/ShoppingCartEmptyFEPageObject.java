package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class ShoppingCartEmptyFEPageObject extends AbstractPage{
	public WebDriver driver;

	public ShoppingCartEmptyFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
