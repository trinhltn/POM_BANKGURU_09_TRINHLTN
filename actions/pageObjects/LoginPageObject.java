package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;

public class LoginPageObject extends AbstractPage{
	public WebDriver driver;
	
	public LoginPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isLoginFormDisplayed() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_FORM);
		return elementIsDisplayed(driver, LoginPageUI.LOGIN_FORM);
	}

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void clickToHereLink() {
		waitForElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void inputToUserIDTextbox(String userIDInfor) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userIDInfor);
	}

	public void inputToPasswordTextbox(String passwordInfor) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordInfor);
	}

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

}
