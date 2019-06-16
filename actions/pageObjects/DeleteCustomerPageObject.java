package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class DeleteCustomerPageObject extends AbstractPage{
	public WebDriver driver;

	public DeleteCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

}
