package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingPage extends CustomWebDriver {


  private HeaderComponent headerComponent;
  private GeneralInformationComponent generalInformationComponent;
  private ContactInformationComponent contactInformationComponent;

  private WebElement ele;

  public SettingPage() {
    PageFactory.initElements(getDriver(),this);
  }

  public HeaderComponent getHeaderComponent(){
    return new HeaderComponent();
  }

  public GeneralInformationComponent getGeneralInformationComponent() {
    return new GeneralInformationComponent();
  }

  public ContactInformationComponent getContactInformationComponent() {
    return new ContactInformationComponent();
  }

  public SettingPage clickOnele(){
    ele.click();
    return  this;
  }
}
