package liveguru;

public class AbstractPageUILiveGuru {
	public static final String ACCOUNT_TAB = "//header//span[text()='Account']";
	public static final String REGISTER_LINK = "//a[text()='Register']";
	public static final String PAGE_CREATE_ACCOUNT = " //h1[text()='Create an Account']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String REGISTER_BUTTON = "//button[@title='Register']";
	public static final String MSG_REGISTER_SUCCESSFULLY = "//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']";
	public static final String MY_ACCOUNT_PAGE = "//span[contains(text(),'My Account')]";
	public static final String TITLE_OF_MY_ACCOUNT_PAGE = "//h1[text()='My Dashboard']";
	public static final String DYNAMIC_LINK_PAGE = "//a[text()='%s']";
	public static final String DYNAMIC_PRICE_OF_MOBILE = "//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";
	public static final String DYNAMIC_IMG_OF_MOBILE = "//a[text()='%s']/parent::h2/parent::div/preceding-sibling::a";
	
	public static final String TITLE_H2_PAGE = "//h2[@class='legend' and text()='%s']";
	
}
