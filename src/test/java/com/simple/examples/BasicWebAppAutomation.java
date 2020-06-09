package com.simple.examples;

import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicWebAppAutomation {

  public static void main(String[] args) throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "16898cd3");
    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);

    URL url = new URL("http://127.0.0.1:4723/wd/hub");
    RemoteWebDriver driver;
    try {
      driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
      driver.get("http://saucelabs.com/test/guinea-pig");
      WebElement div = driver.findElement(By.id("i_am_an_id"));
      System.out.println(div.getText()); //check the text retrieved matches expected value
      driver.findElement(By.id("comments"))
          .sendKeys("My comment"); //populate the comments field by id.

      driver.findElementByXPath("//form[@id='jumpContact']//input[@id='fbemail']").click();
      driver.getKeyboard().sendKeys("taral@gmail.com");
      Thread.sleep(10000);
      driver.quit();
    } catch (Exception e) {
      System.err.println("Error:" + e.getMessage());
    }
  }



}
