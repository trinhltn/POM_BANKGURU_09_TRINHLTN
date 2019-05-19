package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage{
	public WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
		System.out.println("Driver New Account Page = "+driver.toString());
	}
	
	public void clickToCustomerNameTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
	}
	
	public void clickToAddressTextArea() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
	}
	
	public void clickToCityTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.CITY_TEXTBOX);
	}
	
	public void clickToStateTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.STATE_TEXTBOX);
	}
	
	public void clickToPINTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PIN_TEXTBOX);
	}
	
	public void clickToPhoneTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX);
	}
	
	public void clickToEmailTextBox() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		clickToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
	}
	
	public boolean isCustomerNameNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_EMPTY_TEXT);
	}
	
	public boolean isCityNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CITY_NOT_EMPTY_TEXT);
	}
	
	public boolean isStateNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.STATE_NOT_EMPTY_TEXT);
	}
	
	public boolean isCustomerNameNotNumericDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_NUMERIC_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_NUMERIC_TEXT);
	}
	
	public boolean isCityNotNumericDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_NOT_NUMERIC_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CITY_NOT_NUMERIC_TEXT);
	}
	
	public boolean isStateNotNumericDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_NOT_NUMERIC_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.STATE_NOT_NUMERIC_TEXT);
	}
	
	public boolean isCustomerNameNotSpecialCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_SPECIAL_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_SPECIAL_CHARACTERS_TEXT);
	}
	
	public boolean isEmailNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_NOT_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.EMAIL_NOT_BLANK_SPACE_TEXT);
	}
	
	public boolean isCityNotSpecialCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_NOT_SPECIAL_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CITY_NOT_SPECIAL_CHARACTERS_TEXT);
	}
	
	public boolean isStateNotSpecialCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_NOT_SPECIAL_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.STATE_NOT_SPECIAL_CHARACTERS_TEXT);
	}
	
	public boolean isCustomerNameNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isCityNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.CITY_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isAddressNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.ADDRESS_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isStateNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.STATE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isPINMust6DigitsDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_MUST_6_DEGITS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PIN_MUST_6_DEGITS_TEXT);
	}
	
	public boolean isPINMustCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_MUST_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PIN_MUST_CHARACTERS_TEXT);
	}
	
	public boolean isPINNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PIN_NOT_EMPTY_TEXT);
	}
	
	public boolean isPINNotSpecialCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_NOT_SPECIAL_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PIN_NOT_SPECIAL_CHARACTERS_TEXT);
	}
	
	public boolean isPhoneNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PHONE_NOT_EMPTY_TEXT);
	}
	
	public boolean isPINNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PIN_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isPhoneNotFirstCharacterBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PHONE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT);
	}
	
	public boolean isPhoneNotBlankSpaceDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_NOT_BLANK_SPACE_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PHONE_NOT_BLANK_SPACE_TEXT);
	}
	
	public boolean isPhoneNotSpecialCharactersDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_NOT_SPECIAL_CHARACTERS_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.PHONE_NOT_SPECIAL_CHARACTERS_TEXT);
	}
	
	public boolean isEmailInCorrectDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_IN_CORRECT_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.EMAIL_IN_CORRECT_TEXT);
	}
	
	public void sendkeyToCustomerName(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, value);
	}
	
	public void sendkeyToAddress(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendkeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, value);
	}
	
	public void sendkeyToCity(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, value);
	}
	
	public void sendkeyToSate(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, value);
	}
	
	public void sendkeyToPIN(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, value);
	}
	
	public void sendkeyToPhone(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX, value);
	}
	
	public void sendkeyToEmail(String value) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, value);
	}
	
	public void pressTABKey(String locator, Keys key) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyboardToElement(driver, locator, key);
	}
	
	public boolean isAddressNotEmptyDisplay() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_NOT_EMPTY_TEXT);
		return elementIsDisplayed(driver, NewCustomerPageUI.ADDRESS_NOT_EMPTY_TEXT);
	}

}
