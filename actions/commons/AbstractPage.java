package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractPage {
	WebElement element;
	List <WebElement> elements;
	JavascriptExecutor jsExecutor;
	WebDriverWait explicitWait;
	Actions action;
	
    //WebBrowser
	public void openAnyUrl(WebDriver driver, String Url) {
		driver.get(Url);
	}
	
	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}
	
	public void getCurrentPageUrl(WebDriver driver) {
		driver.getCurrentUrl();
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
	
	//WebElement
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void senkeyToElement(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public String getSelectedItemInDropDown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath, String expectedValueItem) throws Exception {

		element = driver.findElement(By.xpath(parentXpath));
		explicitWait = new WebDriverWait(driver, 30);
		jsExecutor.executeScript("arguments[0].click();", element);
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		for (WebElement childElement : allItems) {
			if (childElement.getText().contains(expectedValueItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
				Thread.sleep(1000);
				
				if(childElement.isDisplayed()) {
					childElement.click();
				}
				else {
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
	
	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void unCheckToCheckBox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean elementIsDisplayed(WebDriver driver, String locator) {
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
      Set <String> allWindows = driver.getWindowHandles();
      for(String runWindow : allWindows) {
          if(!runWindow.equals(parentID)) {
              driver.switchTo().window(runWindow);
              break;
          }
      }
	 }
	  
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
      Set <String> allWindows = driver.getWindowHandles();
      for(String runWindows : allWindows) {
          driver.switchTo().window(runWindows);
          String currentWin = driver.getTitle();
          if(currentWin.equals(expectedTitle)) {
              break;
          }
      }
	}
  
	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentID) {
      Set <String> allWindows = driver.getWindowHandles();
      for(String runWindows : allWindows) {
          if(!runWindows.equals(parentID)) {
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
	
	public void hoverMouseToElement (WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}
	
	public void rightClick (WebDriver driver, String locator) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.contextClick(element).perform();
	}
	
	public void dragAndDrop (WebDriver driver, String locatorFrom, String locatorTo) {
		action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorFrom));
		  
		action.dragAndDrop(source, target).perform();
	}
	
	public void sendKeyboardToElement (WebDriver driver, String locator, String key) {
		action = new Actions(driver);
		//element = driver.findElement(By.xpath(locator));
		
		action.sendKeys(Keys.ENTER).build().perform();
		action.keyDown(Keys.CONTROL).sendKeys(key).keyUp(Keys.CONTROL).perform();
	}
	
	public void uploadSenkeyOneFile(WebDriver driver, String locator, String linkFile, String locatorBtnUpload) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(linkFile);
		driver.findElement(By.xpath(locatorBtnUpload)).click();
	}
	
	public void uploadSenkeyMultiFiles(WebDriver driver, String locator, String linkFile, String locatorBtnUpload) {
		
	}
	
	
}
