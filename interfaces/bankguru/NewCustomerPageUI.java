package bankguru;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "//td[text()='Customer Name']/following-sibling::td//input";
	public static final String CUSTOMER_NAME_NOT_EMPTY_TEXT = "//label[text()='Customer name must not be blank']";
	public static final String CUSTOMER_NAME_NOT_NUMERIC_TEXT = "//label[text()='Numbers are not allowed']";
	public static final String CUSTOMER_NAME_NOT_SPECIAL_CHARACTERS_TEXT = "//td[text()='Customer Name']/following-sibling::td//label[text()='Special characters are not allowed']";
	public static final String CUSTOMER_NAME_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//td[text()='Customer Name']/following-sibling::td//label[text()='First character can not have space']";
	
	public static final String ADDRESS_TEXTAREA = "//td[text()='Address']/following-sibling::td//textarea";
	public static final String ADDRESS_NOT_EMPTY_TEXT = "//td[text()='Address']/following-sibling::td//label[text()='Address Field must not be blank']";
	public static final String ADDRESS_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//td[text()='Address']/following-sibling::td//label[text()='First character can not have space']";

	public static final String CITY_TEXTBOX = "//td[text()='City']/following-sibling::td//input";
	public static final String CITY_NOT_EMPTY_TEXT = "//td[text()='City']/following-sibling::td//label[text()='City Field must not be blank']";
	public static final String CITY_NOT_NUMERIC_TEXT = "//td[text()='City']/following-sibling::td//label[text()='Numbers are not allowed']";
	public static final String CITY_NOT_SPECIAL_CHARACTERS_TEXT = "//td[text()='City']/following-sibling::td//label[text()='Special characters are not allowed']";
	public static final String CITY_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//td[text()='City']/following-sibling::td//label[text()='First character can not have space']";

	public static final String STATE_TEXTBOX = "//td[text()='State']/following-sibling::td//input";
	public static final String STATE_NOT_EMPTY_TEXT = "//td[text()='State']/following-sibling::td//label[text()='State must not be blank']";
	public static final String STATE_NOT_NUMERIC_TEXT = "//td[text()='State']/following-sibling::td//label[text()='Numbers are not allowed']";
	public static final String STATE_NOT_SPECIAL_CHARACTERS_TEXT = "//td[text()='State']/following-sibling::td//label[text()='Special characters are not allowed']";
	public static final String STATE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//td[text()='State']/following-sibling::td//label[text()='First character can not have space']";

	public static final String PIN_TEXTBOX = "//td[text()='PIN']/following-sibling::td//input";
	public static final String PIN_MUST_6_DEGITS_TEXT = "//td[text()='PIN']/following-sibling::td//label[text()='PIN Code must have 6 Digits']";
	public static final String PIN_MUST_CHARACTERS_TEXT = "//td[text()='PIN']/following-sibling::td//label[text()='Characters are not allowed']";
	public static final String PIN_NOT_EMPTY_TEXT = "//td[text()='PIN']/following-sibling::td//label[text()='PIN Code must not be blank']";
	public static final String PIN_NOT_SPECIAL_CHARACTERS_TEXT = "//td[text()='PIN']/following-sibling::td//label[text()='Special characters are not allowed']";
	public static final String PIN_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//td[text()='PIN']/following-sibling::td//label[text()='First character can not have space']";

	public static final String PHONE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String PHONE_NOT_EMPTY_TEXT = "//input[@name='telephoneno']/following-sibling::label[text()='Mobile no must not be blank']";
	public static final String PHONE_NOT_FIRST_CHARACTER_BLANK_SPACE_TEXT = "//input[@name='telephoneno']/following-sibling::label[text()='First character can not have space']";
	public static final String PHONE_NOT_BLANK_SPACE_TEXT = "//input[@name='telephoneno']/following-sibling::label[text()='Characters are not allowed']";
	public static final String PHONE_NOT_SPECIAL_CHARACTERS_TEXT = "//input[@name='telephoneno']/following-sibling::label[text()='Special characters are not allowed']";

	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String EMAIL_NOT_BLANK_SPACE_TEXT = "//input[@name='emailid']/following-sibling::label[text()='Email-ID must not be blank']";
	public static final String EMAIL_IN_CORRECT_TEXT = "//input[@name='emailid']/following-sibling::label[text()='Email-ID is not valid']";

}
