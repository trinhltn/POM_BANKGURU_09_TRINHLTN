package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import commons.AbstractPage;
import commons.PageFactoryManager;

public class HomePageObject extends AbstractPage{
	public WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isWelcomeMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
		return elementIsDisplayed(driver, HomePageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isUserIDDisplayed(String userIDInfor) {
		String USER_ID_FORMAT = String.format(HomePageUI.USER_ID_TEXT, userIDInfor);
		waitForElementVisible(driver, USER_ID_FORMAT);
		return elementIsDisplayed(driver, USER_ID_FORMAT);
	}
	
	/*return login page*/
	public LoginPageObject clickToLogOutLink() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
		acceptAlert(driver);
		
		return PageFactoryManager.getLoginPage(driver);
	}

	public NewAccountPageObject openNewAccountPage() {
		waitForElementVisible(driver, HomePageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccoutPage(driver);
	}


}
