package liveguru;

public class AbstractPageUILiveGuru {
	public static final String ACCOUNT_TAB = "//header//span[text()='Account']";
	public static final String REGISTER_LINK = "//a[text()='Register']";
	public static final String DYNAMIC_TEXT_PAGE = " //h1[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON = "//button[@title='%s']";
	public static final String MSG_REGISTER_SUCCESSFULLY = "//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']";
	public static final String MY_ACCOUNT_PAGE = "//span[contains(text(),'My Account')]";
	public static final String DYNAMIC_TEXT_ADDED_TO_CART_SUCCESS = "//span[contains(text(),'%s was added to your shopping cart.')]";
	public static final String DYNAMIC_TEXT_ADDED_TO_COMPARE_SUCCESS = "//span[text()='The product %s has been added to comparison list.']";
	public static final String TEXT_APPLIED_DISCOUNT = "//span[contains(text(),'Coupon code \"GURU50\" was applied.')]";
	public static final String TEXT_ERR_BEYOND_QUANTITY = "//span[contains(text(),'Some of the products cannot be ordered in requested quantity.')]";
	public static final String TEXT_ERR_BEYOND_QUANTITY_2 = "//p[contains(text(),'* The maximum quantity allowed for purchase is 500.')]";
	public static final String TITLE_OF_MY_ACCOUNT_PAGE = "//h1[text()='My Dashboard']";
	public static final String DYNAMIC_LINK_PAGE = "//a[text()='%s']";
	public static final String DYNAMIC_PRICE_OF_MOBILE = "//a[text()='%s']/parent::h2/following-sibling::div//span[@class='price']";
	public static final String DYNAMIC_IMG_OF_MOBILE = "//a[text()='%s']/parent::h2/parent::div/preceding-sibling::a";
	public static final String DYNAMIC_MOBILE_NAME = "//a[@title='%s']";
	public static final String TEXT_PRICE_AT_DETAIL_PAGE = "//span[@class='price']";
	public static final String TEXT_PRICE_DISCOUNT = "//td[contains(text(),'Discount (GURU50)')]/following-sibling::td//span";
	public static final String DYNAMIC_ADD_TO_CART = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//button";
	public static final String DYNAMIC_ADD_TO_COMPARE = "//a[text()='%s']/parent::h2/following-sibling::div[@class='actions']//ul//a[text()='Add to Compare']";
	public static final String QTY_TEXTBOX = "//a[@title='Sony Xperia']/parent::td/following-sibling::td[@class='product-cart-actions']//input";
	public static final String BUTTON_UPDATE = "//a[@title='Sony Xperia']/parent::td/following-sibling::td[@class='product-cart-actions']//button";
	public static final String TEXT_NO_ITEMS_IN_CART = "//div[@class='cart-empty']//p[text()='You have no items in your shopping cart.']";
	public static final String TITLE_H2_PAGE = "//h2[@class='legend' and text()='%s']";
	public static final String DYNAMIC_GET_MOBILE_NAME = "//h2//a[@title='%s']";
	public static final String DYNAMIC_GET_PRICE_IN_COMPARE_PAGE = "//a[@title='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String DYNAMIC_SKU = "//span[text()='SKU']/parent::th/following-sibling::td//div[contains(text(),'%s')]";
	public static final String DYNAMIC_ADD_TO_WISHLIST = "//a[@title='%s']/parent::h2/following-sibling::div[@class='actions']//a[text()='Add to Wishlist']";
	public static final String PAGE_NAME_OF_WISHLIST = "//a[text()='here']/parent::span";
	public static final String DYNAMIC_COMMENT_WISHLIST_TEXT_AREA = "//textarea[@id='%s']";
	public static final String DYNAMIC_QTY_OF_TV_WISHLIST = "//a[text()='%s']/parent::h3/parent::td/following-sibling::td[contains(@class,'customer-wishlist-item-quantity')]//input";
	
}
