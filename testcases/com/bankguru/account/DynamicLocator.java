package com.bankguru.account;

public class DynamicLocator {
	public static void main(String[] args) {
		String DYNAMIC_LINK = "//ul[@class='menusubnav']//a[text()='%s']";
		String DYNAMIC_EDIT_ROW = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']//button[@class='qgrd-edit-row-btn']";
		
		clickToLink(DYNAMIC_LINK, "Manager");
		clickToLink(DYNAMIC_LINK, "New Account");
		
		clickToLink(DYNAMIC_EDIT_ROW, "384187", "Afghanistan", "407124");
	}
	
//	public static void clickToLink(String locator, String pageName) {
//		locator = String.format(locator, pageName);
//		System.out.println(locator);
//	}
//	
//	public static void clickToLink(String locator, String femalesID, String country, String malesID) {
//		locator = String.format(locator, femalesID, country, malesID);
//		System.out.println(locator);
//	}
	
	public static void clickToLink(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println(locator);
	}
}
