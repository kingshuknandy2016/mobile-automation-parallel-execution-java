package com.basics;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Suite1 {

    @Test
    @Parameters({"deviceName","platformVersion","platform","browserName","hubUrl"})
    public void test1(String deviceName,String platformVersion,String platformName, String browserName,String hubUrl) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", platformName);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("browserName",browserName);
        caps.setCapability("platformVersion",platformVersion);
        caps.setCapability("noReset",true);
        //String url = "http://" + "192.168.3.140" + ":" + "4444" + "/wd/hub";
        String url=hubUrl;
        if(platformName.equalsIgnoreCase("Android")){
            RemoteWebDriver driver=new RemoteWebDriver(new URL(url),caps);
            driver.get("https://www.amazon.in/");
            //driver.findElement(By.xpath("//span[text()='Fresh']")).click();
            Thread.sleep(7000);
            driver.quit();
        }else{
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITEST");
            caps.setCapability("xcodeSigningId", "iPhone Developer");
            caps.setCapability("xcodeOrgId","3WS698JC32");
            caps.setCapability(MobileCapabilityType.UDID,"bd21c102521b9dc2837ca16c530669006db71f1b");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
            caps.setCapability("startIWDP",true);
            IOSDriver driver_ios=new IOSDriver(new URL(url),caps);
            driver_ios.startRecordingScreen();
            driver_ios.get("https://www.amazon.in/");
            //driver_ios.findElement(By.xpath("//a[text()='Best Sellers']")).click();
            Thread.sleep(7000);
            driver_ios.stopRecordingScreen();
            driver_ios.quit();
        }


    }

/*    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY224P7HZB");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //caps.setCapability("platformVersion",platformVersion);
        String url = "http://" + "0.0.0.0" + ":" + "4723" + "/wd/hub";
        AndroidDriver driver=new AndroidDriver(new URL(url),caps);
        driver.startRecordingScreen();
        Thread.sleep(4000);
        driver.get("http://saucelabs.com/test/guinea-pig");
    }*/

}
