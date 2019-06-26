package liveguru;

public class AbstractPageUILiveGuru {
	public static final String ACCOUNT_TAB = "//header//span[text()='Account']";
	public static final String REGISTER_LINK = "//a[text()='Register']";
	public static final String PAGE_CREATE_ACCOUNT = " //h1[text()='Create an Account']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";
	public static final String MSG_REGISTER_SUCCESSFULLY = "//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']";
	public static final String MY_ACCOUNT_PAGE = "//span[contains(text(),'My Account')]";
	public static final String TEXT_ADDED_TO_CART_IPHONE = "//span[contains(text(),'IPhone was added to your shopping cart.')]";
	public static final String TEXT_APPLIED_DISCOUNT = "//span[contains(text(),'Coupon code \"GURU50\" was applied.')]";
	public static final String TITLE_OF_MY_ACCOUNT_PAGE = "//h1[text()='My Dashboard']";
	public static final String DYNAMIC_LINK_PAGE = "//a[text()='%s']";
	public static final String DYNAMIC_PRICE_OF_MOBILE = "//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";
	public static final String DYNAMIC_IMG_OF_MOBILE = "//a[text()='%s']/parent::h2/parent::div/preceding-sibling::a";
	public static final String DYNAMIC_MOBILE_NAME = "//a[@title='%s']";
	public static final String TEXT_PRICE_AT_DETAIL_PAGE = "//span[@class='price']";
	public static final String TEXT_PRICE_DISCOUNT = "//td[contains(text(),'Discount (GURU50)')]/following-sibling::td//span";
	public static final String DYNAMIC_ADD_TO_CART = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//button";
	
	public static final String TITLE_H2_PAGE = "//h2[@class='legend' and text()='%s']";
	
}
