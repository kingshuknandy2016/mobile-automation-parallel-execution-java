package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CustomWebDriver {


  private HeaderComponent headerComponent;

  public HomePage() {
    PageFactory.initElements(getDriver(),this);
  }

  public HeaderComponent getHeaderComponent(){
    return new HeaderComponent();
  }
}
