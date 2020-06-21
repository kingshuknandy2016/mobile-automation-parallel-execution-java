package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPopupPage extends CustomWebDriver {

  @FindBy(xpath="//button[text()='Continue']")
  private WebElement element;

  public NotificationPopupPage() {
    PageFactory.initElements(getDriver(),this);
  }

  public NotificationPopupPage clickOnContinue(){
    element.click();
    return this;
  }
}
