package com.mobile.android.pageobject;

import com.general.utils.PropertyFileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CustomMobileDriver {

  private static AppiumDriver<AndroidElement> appiumDriver;

  public AppiumDriver<AndroidElement> getAppiumDriver() {
    if (appiumDriver != null) {
      return appiumDriver;
    } else {
      return initAppiumDriver();
    }
  }

  private AppiumDriver initAppiumDriver() {
    PropertyFileUtils propertyFileUtils = new PropertyFileUtils(
        System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties");
    HashMap<String, Object> propertyMap = propertyFileUtils.readPropertyFile();
    DesiredCapabilities caps = new DesiredCapabilities();

    if (propertyMap.get("platformName").toString().equalsIgnoreCase("com/mobile/android")) {
      caps.setCapability(MobileCapabilityType.PLATFORM_NAME, propertyMap.get("platformName"));
      caps.setCapability(MobileCapabilityType.DEVICE_NAME, propertyMap.get("deviceName"));
      caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, propertyMap.get("appPackage"));
      caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, propertyMap.get("appActivity"));
      caps.setCapability(MobileCapabilityType.NO_RESET,
          Boolean.parseBoolean(propertyMap.get("noReset").toString()));
    } else {

    }

    String url = propertyMap.get("url").toString();
    try {
      appiumDriver = new AppiumDriver(new URL(url), caps);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return appiumDriver;
  }

  /**
   * @description : (DEBUG Method)Get all the Context Present in the APP
   * 								And print all the Page Source included within each context
   */
  public static void getContextAndPageSource(){

    Set<String> contextHandles=appiumDriver.getContextHandles();
    Iterator iterator=contextHandles.iterator();
    String contextName;
    while (iterator.hasNext()){
      contextName=iterator.next().toString();
      System.out.println("==================Start of :"+contextName+" context=========================");
      appiumDriver.context(contextName);
      System.out.println(appiumDriver.getPageSource());
      System.out.println("******************End of :  "+contextName+" context*************************");

    }
  }

  /**
   * @description : (DEBUG Method) It find the status of the element
   * 								whether it is present or not etc
   * @param element
   */
  public static void elementStatusFinder(AndroidElement element) {
    System.out.println("=====================================");
    System.out.println("Element:" + element.getAttribute("innerHTML"));
    System.out.println("Displayed:" + element.isDisplayed());
    System.out.println("Enabled:" + element.isEnabled());
    System.out.println("Selected:" + element.isSelected());
    System.out.println("=====================================");
  }

  /**
   * @description : This will scroll to specific Element if the element is visible
   * @param element
   */
  public static void scrollToElement(AndroidElement element){
    TouchActions action = new TouchActions(appiumDriver);
    action.scroll(element, 10, 100);
    action.perform();
  }

  /**
   * @description : Swipe from Bottom to Top 80%Y-axis to 20%Y-Axis
   * @throws InterruptedException
   */
  public static void swipeFromBottomToTop() throws InterruptedException {
    Dimension size = appiumDriver.manage().window().getSize();
    System.out.println("Size:" + size);
    int starty = (int) (size.height * 0.80); //starty point which is at bottom side of screen.
    int endy = (int) (size.height * 0.20);   //endy point which is at top side of screen.
    int x = size.width / 2; //horizontal point where you wants to swipe

    TouchAction touchAction = new TouchAction(appiumDriver);
    touchAction
        .press(PointOption.point(x, starty))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
        .moveTo(PointOption.point(x, endy))
        .release().perform();
    Thread.sleep(2000);
  }

  /**
   * @description : Swipe from Top to Bottom 20%Y-axis to 20%Y-Axis to 80%Y axis
   * @throws InterruptedException
   */
  public static void swipeFromTopToBottom(){

  }

}
