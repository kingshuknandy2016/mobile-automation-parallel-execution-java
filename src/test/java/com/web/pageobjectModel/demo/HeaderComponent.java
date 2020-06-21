package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent extends CustomWebDriver {

  @FindBy(xpath = "//a[text()='settings']")
  private WebElement settingsLink;

  public HeaderComponent() {
    PageFactory.initElements(getDriver(),this);
  }

  public HeaderComponent clickOnSettingsLink() throws InterruptedException {
    settingsLink.click();
    waitForPageToLoad();
    Thread.sleep(7000);
    return this;
  }

  public HeaderComponent clickOnSigout() throws InterruptedException {
    settingsLink.click();
    waitForPageToLoad();
    Thread.sleep(7000);
    return this;
  }
}
