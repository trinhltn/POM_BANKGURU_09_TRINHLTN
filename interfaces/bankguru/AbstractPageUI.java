package bankguru;

public class AbstractPageUI {
	public static final String HOME_PAGE_LINK = "//ul[@class='menusubnav']//a[text()='Manager']";
	public static final String NEW_ACCOUNT_LINK = "//ul[@class='menusubnav']//a[text()='New Account']";
	public static final String FUND_TRANSFER_LINK = "//ul[@class='menusubnav']//a[text()='Fund Transfer']";
	public static final String DEPOSIT_LINK = "//ul[@class='menusubnav']//a[text()='Deposit']";
	public static final String NEW_CUSTOMER_LINK = "//ul[@class='menusubnav']//a[text()='New Customer']";
	
	public static final String DYNAMIC_LINK = "//ul[@class='menusubnav']//a[text()='%s']";
	public static final String DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX = "(//textarea | //input)[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST = "//select[@name='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//td[contains(text(),'%s')]/following-sibling::td/label";
	public static final String DYNAMIC_PAGE_TITLE = "//p[@class='heading3' and contains(text(),'%s')]";
	public static final String DOB = "//input[@name='dob']";
	public static final String DYNAMIC_VALUE_IN_TABLE = "//td[text()='%s']/following-sibling::td";
	
}
