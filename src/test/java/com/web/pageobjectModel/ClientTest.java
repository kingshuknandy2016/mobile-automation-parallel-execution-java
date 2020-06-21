package com.web.pageobjectModel;

import com.web.pageobjectModel.demo.HomePage;
import com.web.pageobjectModel.demo.LoginPage;
import com.web.pageobjectModel.demo.NotificationPopupPage;
import com.web.pageobjectModel.demo.SettingPage;

public class ClientTest {

  public static void main(String[] args) throws InterruptedException {
    new LoginPage()
        .loginIntoApp("kingshuknandy2016@gmail.com","Test@123456");

    new NotificationPopupPage()
        .clickOnContinue();

    new HomePage()
        .getHeaderComponent()
              .clickOnSettingsLink();

    SettingPage settingPage=new SettingPage();
    settingPage
        .getGeneralInformationComponent()
              .clickOnEditGeneralInfo()
              .clickOnSave();

    settingPage
        .getContactInformationComponent()
              .clickOnEditContactInfo()
              .clickOnSave();

    CustomWebDriver.closeDriverInstance();
  }
}
