package com.web.pageobjectModel;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

	private static WebDriver driver;
	private static WebDriverWait wait;

	public static void closeDriverInstance() {
		driver.close();
		driver.quit();
		driver = null;
	}

	public static boolean getDriverStatus() {
		boolean flag = false;
		if (driver != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @description Utility method to retrieve running platform's Operating System.
	 * @return OS Name
	 */
	public static String getOS() {
		String os;
		os = System.getProperty("os.name");
		return os;
	}

	public static String takesScreenhot() {
		String path = "";
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			path = System.getProperty("user.dir") + File.separator + "reportsandlogs" + File.separator + "screenshots"
					+ File.separator + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".png";
			File destinationPath = new File(path);
			Files.copy(sourcePath, destinationPath);

			/*
			 * fileInputStreamReader = new FileInputStream(sourcePath); byte[] bytes = new
			 * byte[(int) sourcePath.length()]; fileInputStreamReader.read(bytes);
			 * encodedBase64 = new String(Base64.encodeBase64(bytes));
			 */

		} catch (IOException e) {
			System.out.println("Error occured while execution of takescreenshot object");
			System.out.println("Exception:" + e.getLocalizedMessage());
		}
		new Driver().closeDriverInstance();
		/* return "data:image/png;base64," + encodedBase64; */
		return path;
	}

	public Driver() {
	}

	/**
	 * Init chrome driver instnace
	 * @return Driver instance
	 */
	public WebDriver getDriver() {
		if (null != driver) {
			return driver;
		} else {
			return initChromeDriver();
		}
	}

	public WebDriverWait getExplicitWait() {
		if (null != wait) {
			return wait;
		} else {
			return new WebDriverWait(getDriver(), 60);
		}
	}

	/**
	 * Open Chrome driver in headless mode
	 *
	 * @return driver instance
	 */
	private WebDriver initChromeDriver() {
		String platform = getOS();
		System.out.println("Running on Platform " + platform);
		if (platform.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/lib/windows/chromedriver.exe");
		} else if (platform.equalsIgnoreCase("linux")) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		} else if (platform.equalsIgnoreCase("mac")) {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		}

		// ChromeOptions chromeOptions = new ChromeOptions();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		// chromeOptions.addArguments("--log-level=3");
		// chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(/* chromeOptions */);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public void javaScriptClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void ScrollToElement(WebElement webElement) {
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public void waitForElementClickable(Long timeUnit, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnit);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForPageToLoad() {
		new WebDriverWait(driver, 30).until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

	public  WebElement getWebElement(String locator,Object... value){
		return getDriver().findElement(By.xpath(String.format(locator, value,value)));
	}


	public static void main(String[] args) {
		String locator="//div[@class='sLyGP0wLcAHIXOwzPjSkG' and text()='%s' and class()='%s']";
		String taskId="";
		String abc="";
		Driver driver=new Driver();
		WebElement element=driver.getWebElement(locator,taskId,abc);
	}
}
