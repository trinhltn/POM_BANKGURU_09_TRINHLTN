package commons;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	private WebDriver driver;
	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver openMultiBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chromeheadless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		}
		
		System.out.println("Run on browser = " + browserName);
		System.out.println(driver.toString());
		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

	//add driver version 
	protected WebDriver openMultiBrowser(String browserName, String driverVersion) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().version(driverVersion).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().version(driverVersion).setup();
			driver = new FirefoxDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chromeheadless")) {
			WebDriverManager.chromedriver().version(driverVersion).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x768");
			driver = new ChromeDriver(options);
		}
		
		else if (browserName.equalsIgnoreCase("firefoxheadless")) {
			WebDriverManager.firefoxdriver().version(driverVersion).setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		}
		
		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().version(driverVersion).arch32().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().version(driverVersion).setup();
			driver = new EdgeDriver();
		}

		System.out.println("Run on browser = " + browserName);
		System.out.println(driver.toString());
		driver.manage().timeouts().implicitlyWait(Constants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		if(driver.toString().toLowerCase().contains("internet explorer")) {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return driver;
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED==");
			else
				log.info("===FAILED==");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		boolean status;
		try {
			if (actual instanceof String && expected instanceof String) {
				actual = actual.toString().trim();
				log.info("Actual = " + actual);
				expected = expected.toString().trim();
				log.info("Expected = " + expected);
				status = (actual.equals(expected));
			} else {
				status = (actual == expected);
			}

			log.info("Compare value = " + status);
			if (status) {
				log.info("===PASSED===");
			} else {
				log.info("===FAILED===");
			}
			Assert.assertEquals(actual, expected, "Value is not matching!");
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
					Process process = Runtime.getRuntime().exec(cmd);
					process.waitFor();
				}
			}
			log.info("-------QUIT BROWSER SUCCESS-------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
	
	public String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		DateTime nowLocal = new DateTime();
		System.out.println("Time in UTC" + nowUTC);
		System.out.println("Time in Local" + nowLocal);
		return nowUTC.getDayOfMonth() + "";
	}

	public String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if(month<10) {
			String monthValue = "0"+month;
			return monthValue;
		}
		else {
			return month+"";
		}
	}
	
	public String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear()+"";
	}
	
	public String getToday() {
		return getCurrentYear()+"-"+getCurrentMonth()+"-"+getCurrentDay();
	}

}
