package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class ShoppingCartFEPageObject extends AbstractPage{
	public WebDriver driver;

	public ShoppingCartFEPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
