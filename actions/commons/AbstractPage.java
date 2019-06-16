package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bankguru.AbstractPageUI;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;

public class AbstractPage extends AbstractPageUI {
	WebElement element;
	List<WebElement> elements;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	Actions action;

	String rootFolder = System.getProperty("user.dir");

	By byLocator;

	// WebBrowser
	public void openAnyUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void getPageSource(WebDriver driver) {
		driver.getPageSource();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// WebElement
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		highlightElement(driver, element);
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		highlightElement(driver, element);
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		highlightElement(driver, element);
		element.clear();
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueSendkey, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		highlightElement(driver, element);
		element.clear();
		element.sendKeys(valueSendkey);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public String getSelectedItemInDropDown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedItemInDropDown(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedValueItem) throws Exception {

		element = driver.findElement(By.xpath(parentXpath));
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor.executeScript("arguments[0].click();", element);

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement childElement : allItems) {
			if (childElement.getText().contains(expectedValueItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				Thread.sleep(1000);

				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					jsExecutor.executeScript("arguments[0].click();", childElement);
				}
				Thread.sleep(1000);
				break;
			}
		}

	}
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.getText().trim();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean elementIsDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean elementIsDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean elementIsSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean elementIsEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(expectedTitle)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String locatorFrom, String locatorTo) {
		action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorFrom));

		action.dragAndDrop(source, target).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}

	public void uploadSenkeyOneFile(WebDriver driver, String locator, String linkFile, String locatorBtnUpload) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(linkFile);
		driver.findElement(By.xpath(locatorBtnUpload)).click();
	}

	public void uploadSenkeyMultiFiles(WebDriver driver, String locator, String fileName01, String fileName02,
			String fileName03, String locatorBtnUpload) throws Exception {
		element = driver.findElement(By.xpath(locator));

		String fileNamePath01 = rootFolder + "\\uploadFiles\\" + fileName01;
		String fileNamePath02 = rootFolder + "\\uploadFiles\\" + fileName02;
		String fileNamePath03 = rootFolder + "\\uploadFiles\\" + fileName03;
		element.sendKeys(fileNamePath01 + "\n" + fileNamePath02 + "\n" + fileNamePath03);
		Thread.sleep(5000);
		driver.findElement(By.xpath(locatorBtnUpload)).click();
		Thread.sleep(5000);
	}

	public void uploadRobot(WebDriver driver, String fileNamePath01, String locatorUploadFile, String locatorBtnUpload)
			throws Exception {
		StringSelection select = new StringSelection(fileNamePath01);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		element = driver.findElement(By.xpath(locatorUploadFile));
		element.click();
		Thread.sleep(1000);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		driver.findElement(By.xpath(locatorBtnUpload)).click();
	}

	public void uploadAutoIT(WebDriver driver, String locator, String fileName01, String locatorBtnUpload)
			throws Exception {
		element = driver.findElement(By.xpath(locator));
		element.click();
		Thread.sleep(1000);
		String fileNamePath01 = rootFolder + "\\uploadFiles\\" + fileName01;
		String chromePath = rootFolder + "\\uploadFiles\\chrome.exe";
		Runtime.getRuntime().exec(new String[] { chromePath, fileNamePath01 });
		Thread.sleep(3000);

		driver.findElement(By.xpath(locatorBtnUpload)).click();
		Thread.sleep(5000);
	}

	// JavascriptExecutor
	public String executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript(javaSript);
	}

	public Object clickToElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}

	public Object sendkeyToElementByJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public Object scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public Object scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px groove red'", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeAttributeOfElement(WebDriver driver, WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.location = '" + url + "'");
	}

	public boolean checkRealImg(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);
		if (!ImagePresent) {
			return false;
		} else {
			return true;
		}
	}

	public void waitForElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, 30);
		locator = String.format(locator, (Object[]) values);
		byLocator = By.xpath(locator);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, 30);
		byLocator = By.xpath(locator);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, Constants.LONG_TIMEOUT);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.HOME_PAGE_LINK);
		clickToElement(driver, AbstractPageUI.HOME_PAGE_LINK);
		return PageFactoryManager.getHomePage(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.DEPOSIT_LINK);
		clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
		return PageFactoryManager.getDepositPage(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
		return PageFactoryManager.getFundTransferPage(driver);
	}

	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, AbstractPageUI.NEW_ACCOUNT_LINK);
		return PageFactoryManager.getNewAccoutPage(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
		return PageFactoryManager.getNewCustomerPage(driver);
	}

	// 1 hàm mở ra 14 page (<=20 pages) => return page trong tầng pageObject
	public AbstractPage openMultiPage(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

		switch (pageName) {
		case "Manager":
			return PageFactoryManager.getHomePage(driver);
		case "New Account":
			return PageFactoryManager.getNewAccoutPage(driver);
		case "Fund Transfer":
			return PageFactoryManager.getFundTransferPage(driver);
		case "Deposit":
			return PageFactoryManager.getDepositPage(driver);
		case "New Customer":
			return PageFactoryManager.getNewCustomerPage(driver);
		case "Edit Customer":
			return PageFactoryManager.getEditCustomerPage(driver);
		case "Delete Customer":
			return PageFactoryManager.getDeleteCustomerPage(driver);
		case "Edit Account":
			return PageFactoryManager.getEditAccountPage(driver);
		case "Delete Account":
			return PageFactoryManager.getDeleteAccountPage(driver);
		case "Withdrawal":
			return PageFactoryManager.getWithdrawalPage(driver);
		case "Change Password":
			return PageFactoryManager.getChangePasswordPage(driver);
		case "Balance Enquiry":
			return PageFactoryManager.getBalanceEnquiryPage(driver);
		case "Mini Statement":
			return PageFactoryManager.getMiniStatementPage(driver);
		case "Customised Statement":
			return PageFactoryManager.getCustomisedStatementPage(driver);

		default:
			return PageFactoryManager.getHomePage(driver);
		}

	}

	public void openMultiPages(WebDriver driver, String pageName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);

	}

	public void waitToElementInVisible(WebDriver driver, String locator) {
		Date date = new Date();
		By byLocator = By.xpath(locator);
		System.out.println("Start time for wait invisible = " + date.toString());
		explicitWait = new WebDriverWait(driver, Constants.SHORT_TIMEOUT);
		overrideTimeout(driver, Constants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
		System.out.println("End time for wait invisible = " + new Date().toString());
		overrideTimeout(driver, Constants.LONG_TIMEOUT);
	}

	public boolean isControlUnDisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Start time = " + date.toString());
		overrideTimeout(driver, Constants.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));

		if (elements.size() == 0) {
			System.out.println("Element not in DOM");
			System.out.println("End time = " + new Date().toString());
			overrideTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		}

		else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visible/ displayed");
			System.out.println("End time = " + new Date().toString());
			overrideTimeout(driver, Constants.LONG_TIMEOUT);
			return true;
		}

		else {
			System.out.println("Element in DOM and visible");
			overrideTimeout(driver, Constants.LONG_TIMEOUT);
			return false;
		}
	}

	public void overrideTimeout(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void clickToDynamicButtonTextBoxTextArea(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
	}

	public void sendKeyToDynamicButtonTextBoxTextArea(WebDriver driver, String fieldName, String value) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, value, fieldName);
	}

	public String getDynamicErrorMessage(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, fieldName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_ERROR_MESSAGE, fieldName);
	}
	
	public String getDynamicValueInTable(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_VALUE_IN_TABLE, fieldName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_VALUE_IN_TABLE, fieldName);
	}
	
	public void selectValueInDynamicDropdown(WebDriver driver, String dropdownID, String valueItem) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownID);
		selectItemInDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, valueItem, dropdownID);
	}
	
	public String getFirstItemValueInDynamicDropdown(WebDriver driver, String dropdownID) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownID);
		return getSelectedItemInDropDown(driver, AbstractPageUI.DYNAMIC_DROPDOWN_LIST, dropdownID);
	}
	
	public String getDynamicTextValueInTextbox(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
		return getAttributeValue(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, "value", fieldName);
	}

	public String getDynamicTextValueInTextArea(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TEXTAREA_TEXTBOX_BUTTON_CHECKBOX, fieldName);
	}

	public boolean isDynamicPageTitleDisplayed(WebDriver driver, String pageTitle) {
		waitForElementVisible(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, pageTitle);
		return elementIsDisplayed(driver, AbstractPageUI.DYNAMIC_PAGE_TITLE, pageTitle);
	}
}
