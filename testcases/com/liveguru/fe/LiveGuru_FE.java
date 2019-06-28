package com.liveguru.fe;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageFactoryManager;
import pageObjects.AccountInformationLiveGuruFEPageObject;
import pageObjects.CompareFEPageObject;
import pageObjects.HomeLiveGuruFEPageObject;
import pageObjects.MobileLiveGuruFEPageObject;
import pageObjects.MyAccountLiveGuruFEPageObject;
import pageObjects.ShareWishlistPageObject;
import pageObjects.ShoppingCartEmptyFEPageObject;
import pageObjects.ShoppingCartFEPageObject;
import pageObjects.TVLiveGuruFEPageObject;
import pageObjects.WishlistFEPageObject;
import pageObjects.XperiaDetailFEPageObject;

public class LiveGuru_FE extends AbstractTest {
	private WebDriver driver;
	HomeLiveGuruFEPageObject homeLiveGuruFEPage;
	MyAccountLiveGuruFEPageObject myAccountLiveGuruFEPage;
	AccountInformationLiveGuruFEPageObject accountInformationFEPage;
	MobileLiveGuruFEPageObject mobileLiveGuruFEPage;
	XperiaDetailFEPageObject xperiaDetailPage;
	ShoppingCartFEPageObject shoppingCartFEPage;
	ShoppingCartEmptyFEPageObject ShoppingCartEmptyPage;
	TVLiveGuruFEPageObject tvPage;
	CompareFEPageObject comparePage;
	WishlistFEPageObject wishlistPage;
	ShareWishlistPageObject shareWishlistPage;
	String firstName, lastName, email, password;
	String priceOfSonyXperia, priceOfSonyXperiaDetail;
	String priceSony = "$100.00";
	String priceIPhone = "$500.00";
	String couponCode = "GURU50";
	String discountIPhone = "-$25.00";
	String quantity = "501";
	String parentID;
	String msgAddedWishlistSuccess = " has been added to your wishlist. Click here to continue shopping.";
	String emailComment = "trinh123@gmail.com";
	String message = " send msg for me";

	@Parameters({ "browser", "version" })
	@BeforeClass
	public void beforeTest(String browserName, String driverVersion) {
		driver = openMultiBrowser(browserName, driverVersion);
		driver.get(Constants.LIVE_GURU_FE_SERVER_URL);
		homeLiveGuruFEPage = PageFactoryManager.getHomeLiveGuruPage(driver);

		firstName = "Trinh";
		lastName = "Le";
		email = "trinh" + randomNumber() + "@gmail.com";
		password = "123123";

	}

	@Test
	public void TC_01_LiveGuru_FE_RegisterToSystem() {
		log.info("Register 01 - Step 01: Click to ACCOUNT menu");
		homeLiveGuruFEPage.clickToACCOUNTTab(driver);
		
		log.info("Register 01 - Step 02: Choose Register link");
		homeLiveGuruFEPage.clickToRegisterLink(driver);
		
		log.info("Register 01 - Step 03: Verify move to create account page");
		verifyTrue(homeLiveGuruFEPage.isTextOfPageDisplayed(driver, "Create an Account"));
		
		log.info("Register 01 - Step 04: Input valid data into all fields");
		homeLiveGuruFEPage.sendKeyToElementsInTextBox(driver, "firstname", firstName);
		homeLiveGuruFEPage.sendKeyToElementsInTextBox(driver, "lastname", lastName);
		homeLiveGuruFEPage.sendKeyToElementsInTextBox(driver, "email_address", email);
		homeLiveGuruFEPage.sendKeyToElementsInTextBox(driver, "password", password);
		homeLiveGuruFEPage.sendKeyToElementsInTextBox(driver, "confirmation", password);
		
		log.info("Register 01 - Step 05: Click to register btn");
		homeLiveGuruFEPage.clickToDynamicButton(driver, "Register");
		
		log.info("Register 01 - Step 07: Verify display msg Thank you for registering with Main Website Store.");
		verifyTrue(homeLiveGuruFEPage.isMsgRegisterSuccessfullyDisplayed(driver));
		
	}
	
	@Test
	public void TC_02_Verify_Data_After_RegisterSuccessfully() {
		log.info("Verify 02 - Step 01: Open LiveGuru99 site "); 
		driver.get(Constants.LIVE_GURU_FE_SERVER_URL);
		
		log.info("Verify 02 - Step 02: click to 'ACCOUNT' tab");
		homeLiveGuruFEPage.clickToACCOUNTTab(driver);
		
		log.info("Verify 02 - Step 03: Open 'MY ACCOUNT' page");
		myAccountLiveGuruFEPage = (MyAccountLiveGuruFEPageObject) homeLiveGuruFEPage.openMultiPageLiveFE(driver, "My Account");
		
		log.info("Verify 02 - Step 04: Verify display MY DASHBOARD");
		verifyTrue(myAccountLiveGuruFEPage.isTitleOfMyAccountPageDisplayed(driver));
		
		log.info("Verify 02 - Step 05: Open 'ACCOUNT INFORMATION' page");
		accountInformationFEPage = (AccountInformationLiveGuruFEPageObject) myAccountLiveGuruFEPage.openMultiPageLiveFE(driver, "Account Information");
		
		log.info("Verify 02 - Step 06: Verify 'ACCOUNT INFORMATION' displayed");
		verifyTrue(accountInformationFEPage.isTitleOfPage(driver, "Account Information"));
		
		log.info("Verify 02 - Step 07: Verify data in 3 fields are correctly");
		verifyEquals(accountInformationFEPage.getDynamicValueOnAttribute(driver, "firstname"), firstName);
		verifyEquals(accountInformationFEPage.getDynamicValueOnAttribute(driver, "lastname"), lastName);
		verifyEquals(accountInformationFEPage.getDynamicValueOnAttribute(driver, "email"), email);
		
	}
	
	@Test
	public void TC_03_Verify_That_Cost_Of_Product_Equal_Between_ListPage_And_DetailPage() {
		log.info("Verify 03 - Step 01: Click on Mobile menu");
		mobileLiveGuruFEPage = (MobileLiveGuruFEPageObject) accountInformationFEPage.openMultiPageLiveFE(driver, "Mobile");
		
		log.info("Verify 03 - Step 02: In the list mobile, get cost of Sony Xperia mobile");
		priceOfSonyXperia = mobileLiveGuruFEPage.getDynamicPriceOfMobile(driver, "Sony Xperia");
		
		log.info("Verify 03 - Step 03: Click on Sony Xperia img");
		mobileLiveGuruFEPage.clickToImgOfMobile(driver, "Sony Xperia");
		
		log.info("Verify 03 - Step 04: Open Sony Xperia detail");
		xperiaDetailPage = (XperiaDetailFEPageObject) mobileLiveGuruFEPage.openMultiPageMobileDetail(driver, "Xperia");
		
		log.info("Verify 03 - Step 05: Get cost Sony Xperia from detail Page");
		priceOfSonyXperiaDetail = xperiaDetailPage.getPriceAtDetailPage(driver);
		
		log.info("Verify 03 - Step 06: Compare price at step 02 and step 05");
		verifyEquals(priceOfSonyXperia, priceOfSonyXperiaDetail);
		verifyEquals(priceOfSonyXperiaDetail, priceSony);
		
	}

	@Test
	public void TC_04_Verify_Discount_Coupon_works_correctly() {
		log.info("Verify 04 - Step 01: Click on 'Mobile' menu");
		mobileLiveGuruFEPage = (MobileLiveGuruFEPageObject) xperiaDetailPage.openMultiPageLiveFE(driver, "Mobile");
		
		log.info("Verify 04 - Step 02: Click ADD TO CART and Verify 'IPhone was added to your shopping cart.' display");
		shoppingCartFEPage = (ShoppingCartFEPageObject) mobileLiveGuruFEPage.openMultiShoppingCart(driver, "IPhone");
		shoppingCartFEPage.isDynamicAddedToCartMobileSuccess(driver, "IPhone");
		
		log.info("Verify 04 - Step 03: Enter Coupon code and click button Apply");
		shoppingCartFEPage.sendKeyToElementsInTextBox(driver, "coupon_code", couponCode);
		shoppingCartFEPage.clickToDynamicButton(driver, "Apply");
		
		log.info("Verify 04 - Step 04: Verify the discount generated");
		verifyTrue(shoppingCartFEPage.isAppliedDiscountMsgSuccess(driver));
		verifyEquals(shoppingCartFEPage.getPriceDiscount(driver), discountIPhone);
		
	}
	
	@Test
	public void TC_05_Verify_Can_Not_Add_More_Than_500_Items() {
		log.info("Verify 05 - Step 01: Click on 'Mobile' menu");
		mobileLiveGuruFEPage = (MobileLiveGuruFEPageObject) shoppingCartFEPage.openMultiPageLiveFE(driver, "Mobile");
		
		log.info("Verify 05 - Step 02: Click ADD TO CART of Sony Xperia");
		shoppingCartFEPage = (ShoppingCartFEPageObject) mobileLiveGuruFEPage.openMultiShoppingCart(driver, "Sony Xperia");
		
		log.info("Verify 05 - Step 03: Change QTY value to 501 and click UPDATE button");
		shoppingCartFEPage.SetQtyEqual501(driver, quantity);
		shoppingCartFEPage.clickToUpdateButton(driver);
		
		log.info("Verify 05 - Step 04: Verify err msg");
		verifyTrue(shoppingCartFEPage.isErrMsgBeyondQuantity(driver));
		verifyTrue(shoppingCartFEPage.isErrMsgBeyondQuantity2(driver));
		
		log.info("Verify 05 - Step 05: Click on EMPTY CART link");
		ShoppingCartEmptyPage = (ShoppingCartEmptyFEPageObject) shoppingCartFEPage.openDynamicPagesFromButtonWithTitle(driver, "Empty Cart");
		
		log.info("Verify 05 - Step 06: Verify cart is empty");
		verifyTrue(ShoppingCartEmptyPage.isTextOfPageDisplayed(driver, "Shopping Cart is Empty"));
		verifyTrue(ShoppingCartEmptyPage.isNoItemsInCartDisplayed(driver));
		
	}
	
	@Test
	public void TC_06_Verify_compare_two_products() {
		log.info("Verify 06 - Step 01: Click on 'Mobile' menu");
		mobileLiveGuruFEPage = (MobileLiveGuruFEPageObject) ShoppingCartEmptyPage.openMultiPageLiveFE(driver, "Mobile");
		
		log.info("Verify 06 - Step 02: Click 'Add to compare' Sony Xperia and IPhone");
		mobileLiveGuruFEPage.clickToDynamicAddToCompare(driver, "Sony Xperia");
		mobileLiveGuruFEPage.isDynamicAddedToCompareMobileSuccess(driver, "Sony Xperia");
		mobileLiveGuruFEPage.clickToDynamicAddToCompare(driver, "IPhone");
		mobileLiveGuruFEPage.isDynamicAddedToCompareMobileSuccess(driver, "IPhone");
		
		log.info("Verify 06 - Step 03: Click COMPARE button");
		comparePage =  (CompareFEPageObject) mobileLiveGuruFEPage.openDynamicPagesFromButtonWithTitle(driver, "Compare");
		
		log.info("Verify 06 - Step 04: Verify popup window - switch windows");
		String parentID = driver.getWindowHandle(); 
		comparePage.switchToChildWindowByID(driver, parentID);
		
		log.info("Verify 06 - Step 05: Verify infor in popup window");
		verifyTrue(comparePage.isTextOfPageDisplayed(driver, "Compare Products"));
		
		verifyTrue(comparePage.isMobileNameDisplayed(driver, "Sony Xperia"));
		verifyEquals(comparePage.getDynamicPriceInComparePage(driver, "Sony Xperia"), priceSony);
		verifyTrue(comparePage.isSKUDisplayed(driver, "MOB001"));
		
		verifyTrue(comparePage.isMobileNameDisplayed(driver, "IPhone"));
		verifyEquals(comparePage.getDynamicPriceInComparePage(driver, "IPhone"), priceIPhone);
		verifyTrue(comparePage.isSKUDisplayed(driver, "MOB0002"));
		
		log.info("Verify 06 - Step 06: Close popup window");
		comparePage.closeAllWithoutParentWindows(driver, parentID);
		
	}
	
	@Test
	public void TC_07_Verify_compare_two_products() {
		log.info("Verify 07 - Step 01: Go to TV menu");
		tvPage = (TVLiveGuruFEPageObject) comparePage.openMultiPageLiveFE(driver, "TV");
		tvPage.isTextOfPageDisplayed(driver, "TV");
		
		log.info("Verify 07 - Step 02: Add 'LG LCD' in your wishlist");
		wishlistPage = tvPage.openWishlistPage(driver, "LG LCD");
		verifyEquals(wishlistPage.getMsgAddedWishlistSuccess(driver), "LG LCD"+msgAddedWishlistSuccess);
		
		log.info("Verify 07 - Step 03: Click 'SHARE WISHLIST' button");
		shareWishlistPage = (ShareWishlistPageObject) wishlistPage.openDynamicPagesFromButtonWithTitle(driver, "Share Wishlist");
		
		log.info("Verify 07 - Step 04: Input email and message into textarea comment and Click 'SHARE WISHLIST' button");
		shareWishlistPage.sendKeyToTextAreaComment(driver, "email_address", emailComment);
		shareWishlistPage.sendKeyToTextAreaComment(driver, "message", message);
		wishlistPage = (WishlistFEPageObject) shareWishlistPage.openWishlistPageFromShareWL(driver, "Share Wishlist");
		
		log.info("Verify 07 - Step 05: Verify have 1 LG LCD in My Wishlist");
		verifyTrue(wishlistPage.isTVNameInMyWishlistDisplayed(driver, "LG LCD"));
		verifyEquals(wishlistPage.getDynamicQtyOnAttributeOfTVWishlist(driver, "LG LCD"), "1");
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
}
