package com.pageobject;

import com.utils.PropertyFileUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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

    if (propertyMap.get("platformName").toString().equalsIgnoreCase("android")) {
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


}
