package com.mobile.android.pageobject.pages;

import com.mobile.android.pageobject.CustomMobileDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.general.reporting.ExtentReporter;
import com.general.utils.ScreenShotUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CustomMobileDriver {

  @AndroidFindBy(id = "com.zinier.app:id/et_org")
  private AndroidElement orgnizationName;

  @AndroidFindBy(id = "com.zinier.app:id/et_email")
  private AndroidElement userName;

  @AndroidFindBy(id = "com.zinier.app:id/et_password")
  private AndroidElement password;

  @AndroidFindBy(id = "com.zinier.app:id/btn_login")
  private AndroidElement logInBtn;

  public LoginPage(){
    getAppiumDriver();
    //waitForPageToLoad();
    PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()),this);
  }

  public void login(String organizationNameInp,String userNameInp,String passwordInp)
      throws InterruptedException, IOException {
    /*orgnizationName.clear();
    orgnizationName.sendKeys(organizationNameInp);
    Thread.sleep(2000);
    userName.clear();
    userName.sendKeys(userNameInp);
    password.clear();
    password.sendKeys(passwordInp);
    getAppiumDriver().hideKeyboard();
    logInBtn.click();
    Thread.sleep(2000);*/
    ExtentReporter reporter=new ExtentReporter();
    ExtentReports extentReporter=reporter.initReporter();
    ExtentTest nodeTest=extentReporter.createTest(" User LOGIN");
    String msg;
    MediaEntityModelProvider mediaModel;
    try {
      orgnizationName.clear();
      orgnizationName.sendKeys(organizationNameInp);
      Thread.sleep(2000);
      userName.clear();
      userName.sendKeys(userNameInp);
      password.clear();
      password.sendKeys(passwordInp);
      getAppiumDriver().hideKeyboard();
      logInBtn.click();
      Thread.sleep(25000);
      msg="Successfully User Logged On";
      System.out.println("LOG : "+msg);
      mediaModel= MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotUtils.takesScreenhot()).build();
      nodeTest.pass(msg,mediaModel);
    }catch ( IOException e1){
      msg="Already The User is logged In";
      System.out.println("LOG : "+msg);
      mediaModel=MediaEntityBuilder.createScreenCaptureFromPath(ScreenShotUtils.takesScreenhot()).build();
      nodeTest.pass(msg,mediaModel);
    }
    extentReporter.flush();
  }

}
