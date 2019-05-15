package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
	
	String rootFolder = System.getProperty("user.dir");
	
	By byLocator;
	long longTimeout = 30;
	long shortTimeout = 5;
	
    //WebBrowser
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
	
	public void sendKeyboardToElement (WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		element = driver.findElement(By.xpath(locator));
		action.sendKeys(element, key).perform();
	}
	
	public void uploadSenkeyOneFile(WebDriver driver, String locator, String linkFile, String locatorBtnUpload) {
		element = driver.findElement(By.xpath(locator));
		element.sendKeys(linkFile);
		driver.findElement(By.xpath(locatorBtnUpload)).click();
	}
	
	public void uploadSenkeyMultiFiles(WebDriver driver, String locator, String fileName01, String fileName02, String fileName03, String locatorBtnUpload) throws Exception {
	    element = driver.findElement(By.xpath(locator));
	
		String fileNamePath01 = rootFolder+"\\uploadFiles\\"+fileName01;
		String fileNamePath02 = rootFolder+"\\uploadFiles\\"+fileName02;
		String fileNamePath03 = rootFolder+"\\uploadFiles\\"+fileName03;
	    element.sendKeys(fileNamePath01 +  "\n" + fileNamePath02 + "\n" + fileNamePath03);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(locatorBtnUpload)).click();
	    Thread.sleep(5000);
	}
	
	public void uploadRobot(WebDriver driver, String fileNamePath01, String locatorUploadFile, String locatorBtnUpload) throws Exception {
		StringSelection select = new  StringSelection(fileNamePath01);
		
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

        element =  driver.findElement(By.xpath(locatorUploadFile));
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

	public void uploadAutoIT(WebDriver driver, String locator, String fileName01, String locatorBtnUpload) throws Exception {
      element =  driver.findElement(By.xpath(locator));
      element.click();
      Thread.sleep(1000);
      String fileNamePath01 = rootFolder+"\\uploadFiles\\"+fileName01;
  	  String chromePath = rootFolder+"\\uploadFiles\\chrome.exe";
	  Runtime.getRuntime().exec(new  String[] { chromePath, fileNamePath01 }); 
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath(locatorBtnUpload)).click();
	  Thread.sleep(5000);
	}

	//JavascriptExecutor 
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
        return js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='6px groove red'", element);
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
  	  } 
        catch (InterruptedException e) {
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
    	Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (!ImagePresent)
        {
             return false;
        }
        else
        {
            return true;
        }
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
    	explicitWait = new WebDriverWait(driver, 30);
    	byLocator = By.xpath(locator);
    	explicitWait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void waitForElementVisible (WebDriver driver, String locator) {
    	explicitWait = new WebDriverWait(driver, 30);
    	byLocator = By.xpath(locator);
    	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }    

    public void waitForElementClickable (WebDriver driver, String locator) {
    	explicitWait = new WebDriverWait(driver, 30);
    	byLocator = By.xpath(locator);
    	explicitWait.until(ExpectedConditions.elementToBeClickable(byLocator));
    }     

    public void waitForElementInVisible (WebDriver driver, String locator) {
    	explicitWait = new WebDriverWait(driver, longTimeout);
    	byLocator = By.xpath(locator);
    	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }      

    public void waitForAlertPresence (WebDriver driver) {
    	explicitWait = new WebDriverWait(driver, longTimeout);
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	explicitWait.until(ExpectedConditions.alertIsPresent());
    }  
    
    
    
    
    
}
