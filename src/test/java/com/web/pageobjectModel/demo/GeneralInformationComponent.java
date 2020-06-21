package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationComponent extends CustomWebDriver {

  @FindBy(id = "editGeneralInfo")
  private WebElement editGeneralInfo;

  @FindBy(id = "saveGeneralInfo")
  private WebElement saveGeneralInfo;

  public GeneralInformationComponent() {
    PageFactory.initElements(getDriver(),this);
  }

  public GeneralInformationComponent clickOnEditGeneralInfo(){
    editGeneralInfo.click();
    waitForPageToLoad();
    return this;
  }

  public GeneralInformationComponent clickOnSave() throws InterruptedException {
    PageFactory.initElements(getDriver(),this);
    waitUntilElementIsClickable(saveGeneralInfo,10000);
    Thread.sleep(2000);
    PageFactory.initElements(getDriver(),this);
    saveGeneralInfo.click();
    return this;
  }
}
