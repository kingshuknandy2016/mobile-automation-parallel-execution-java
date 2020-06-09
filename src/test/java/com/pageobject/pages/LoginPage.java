package com.pageobject.pages;

import com.pageobject.CustomMobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CustomMobileDriver {

  @AndroidFindBy(id = "com.test.app:id/et_email")
  private AndroidElement userName;

  @AndroidFindBy(id = "com.test.app:id/et_password")
  private AndroidElement password;

  @AndroidFindBy(id = "com.test.app:id/btn_login")
  private AndroidElement logInBtn;

  public LoginPage(){
    getAppiumDriver();
    //waitForPageToLoad();
    PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()),this);
  }

  public void login(String userNameInp,String passwordInp) throws InterruptedException {
    userName.clear();
    userName.sendKeys(userNameInp);
    password.clear();
    password.sendKeys(passwordInp);
    getAppiumDriver().hideKeyboard();
    logInBtn.click();
    Thread.sleep(2000);
  }

}
