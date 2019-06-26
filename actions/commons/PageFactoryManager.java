package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AccountInformationLiveGuruFEPageObject;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomisedStatementPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomeLiveGuruFEPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MiniStatementPageObject;
import pageObjects.MobileLiveGuruFEPageObject;
import pageObjects.MyAccountLiveGuruFEPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ShoppingCartFEPageObject;
import pageObjects.WithdrawalPageObject;
import pageObjects.XperiaDetailFEPageObject;

public class PageFactoryManager {
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static NewAccountPageObject getNewAccoutPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	
	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}
	
	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}
	
	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}
	
	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}
	
	public static WithdrawalPageObject getWithdrawalPage(WebDriver driver) {
		return new WithdrawalPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}
	
	public static MiniStatementPageObject getMiniStatementPage(WebDriver driver) {
		return new MiniStatementPageObject(driver);
	}
	
	public static CustomisedStatementPageObject getCustomisedStatementPage(WebDriver driver) {
		return new CustomisedStatementPageObject(driver);
	}
	
	
//------------------------------Page factory manager for live guru FE ------------------------------------------
	
	public static HomeLiveGuruFEPageObject getHomeLiveGuruPage(WebDriver driver) {
		return new HomeLiveGuruFEPageObject(driver);
	}
	
	public static MyAccountLiveGuruFEPageObject getMyAccountLiveGuruPage(WebDriver driver) {
		return new MyAccountLiveGuruFEPageObject(driver);
	}
	
	public static AccountInformationLiveGuruFEPageObject getAccountInformationLiveGuruPage(WebDriver driver) {
		return new AccountInformationLiveGuruFEPageObject(driver);
	}
	
	public static MobileLiveGuruFEPageObject getMobileLiveGuruPage(WebDriver driver) {
		return new MobileLiveGuruFEPageObject(driver);
	}
	
	public static XperiaDetailFEPageObject getXperiaDetailPage(WebDriver driver) {
		return new XperiaDetailFEPageObject(driver);
	}
	
	public static ShoppingCartFEPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartFEPageObject(driver);
	}
	
}
