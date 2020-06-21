package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationComponent extends CustomWebDriver {

  @FindBy(id = "editContactInfo")
  private WebElement editContactInfo;

  @FindBy(id = "saveContactInfo")
  private WebElement saveContactInfo;

  public ContactInformationComponent() {
    PageFactory.initElements(getDriver(),this);
  }

  public ContactInformationComponent clickOnEditContactInfo(){
    editContactInfo.click();
    waitForPageToLoad();
    return this;
  }

  public ContactInformationComponent clickOnSave() throws InterruptedException {
    PageFactory.initElements(getDriver(),this);
    waitUntilElementIsClickable(saveContactInfo,10000);
    Thread.sleep(2000);
    PageFactory.initElements(getDriver(),this);
    saveContactInfo.click();
    return this;
  }
}
