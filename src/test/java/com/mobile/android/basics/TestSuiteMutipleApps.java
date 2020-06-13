package com.mobile.android.basics;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuiteMutipleApps {
    AndroidDriver driver;

    @Test
    @Parameters({"deviceName","platformVersion","platform"})
    public void testApp(String deviceName,String platformVersion,String platformName) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("deviceName", deviceName);
        //caps.setCapability("browserName",browserName);
        caps.setCapability("platformVersion",platformVersion);
        //caps.setCapability("noReset",true);

        // App1 capabilities
        String calculatorAppPackageName="com.google.android.calculator";
        String calculatorAppActivityName="com.android.calculator2.Calculator";

        // App2 capabilities
        String settingsAppPackageName="com.android.settings";
        String settingsAppActivityName="com.android.settings.Settings";
        //Calculator
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, calculatorAppPackageName);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, calculatorAppActivityName);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
        //Perform calculation in calculator
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        //Validate results
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        System.out.println("Result : " + result);

        Thread.sleep(2000);
        //launch settings App
        driver.startActivity(new Activity(settingsAppPackageName,settingsAppActivityName));
        Thread.sleep(3000);

        //Re launch calculator App
        driver.startActivity(new Activity(calculatorAppPackageName, calculatorAppActivityName));
        Thread.sleep(2000);

        //Assert.assertEquals("Incorrect Result", 15,(int) Integer.valueOf(result));
        driver.close();
        driver.quit();

    }

}
