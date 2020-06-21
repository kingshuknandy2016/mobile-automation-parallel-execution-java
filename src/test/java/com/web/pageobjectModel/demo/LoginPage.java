package com.web.pageobjectModel.demo;

import com.web.pageobjectModel.CustomWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CustomWebDriver {

  @FindBy(id = "email")
  private WebElement usernameInp;

  @FindBy(id = "password")
  private WebElement passwordInp;

  @FindBy(id = "btnLogin")
  private WebElement submitBtn;

  public LoginPage() {
    getDriver().get("https://onetouchreveal.com/login");
    PageFactory.initElements(getDriver(),this);
  }

  public LoginPage loginIntoApp(String username,String password) throws InterruptedException {
    usernameInp.sendKeys(username);
    passwordInp.sendKeys(password);
    submitBtn.click();
    Thread.sleep(7000);
    return this;
  }

}
