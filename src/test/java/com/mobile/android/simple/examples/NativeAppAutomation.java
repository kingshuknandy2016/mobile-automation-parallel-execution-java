package com.mobile.android.simple.examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NativeAppAutomation {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "16898cd3");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.zinier.app");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.zinier.app.ui.activities.splash.SplashActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET,true);

        String url = "http://0.0.0.0:4723/wd/hub";
        AppiumDriver driver=new AppiumDriver(new URL(url),caps);
        Thread.sleep(4000);
        //getContextAndPageSource(driver);
        AndroidElement orgnizationName=(AndroidElement) driver.findElement(By.id("com.zinier.app:id/et_org"));
        orgnizationName.clear();
        orgnizationName.sendKeys("afourtechqa");
        Thread.sleep(2000);
        AndroidElement userName=(AndroidElement) driver.findElement(By.id("com.zinier.app:id/et_email"));
        userName.clear();
        userName.sendKeys("kingshuk.nandy+11@afourtech.com");
        Thread.sleep(2000);
        AndroidElement password=(AndroidElement) driver.findElement(By.id("com.zinier.app:id/et_password"));
        password.clear();
        password.sendKeys("Test@123456");
        Thread.sleep(2000);

        driver.hideKeyboard();
        AndroidElement logInBtn=(AndroidElement) driver.findElement(By.id("com.zinier.app:id/btn_login"));
        logInBtn.click();
        Thread.sleep(4000);
    }

    public static void getContextAndPageSource(AppiumDriver driver){

        Set<String> contextHandles=driver.getContextHandles();
        Iterator iterator=contextHandles.iterator();
        String contextName;
        while (iterator.hasNext()){
            contextName=iterator.next().toString();
            System.out.println("==================Start of :"+contextName+" context=========================");
            driver.context(contextName);
            System.out.println(driver.getPageSource());
            System.out.println("******************End of :  "+contextName+" context*************************");

        }
    }


}
