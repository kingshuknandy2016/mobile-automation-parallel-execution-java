package com.mobile.android.pageobject.library;

import com.mobile.android.pageobject.CustomMobileDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class DeviceLibrary extends CustomMobileDriver {

  private AndroidDriver androidDriver;

  public DeviceLibrary(){
    androidDriver=(AndroidDriver) getAppiumDriver();
  }

  /**
   * @description starts an activity
   * @param appPackage
   * @param appActivity
   */
  public void startActivity(String appPackage, String appActivity){
    androidDriver.startActivity(new Activity(appPackage,appActivity));
  }

  public void commonMethods(){
    androidDriver.startActivity(new Activity("appPackage","appPackage"));
    String currentActivityName=androidDriver.currentActivity();
    String currentPackageName=androidDriver.getCurrentPackage();
  }

}
