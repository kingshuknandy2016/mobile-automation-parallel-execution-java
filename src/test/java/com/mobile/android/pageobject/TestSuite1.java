package com.mobile.android.pageobject;

import com.mobile.android.pageobject.pages.LoginPage;
import java.io.IOException;

public class TestSuite1 {

  public static void main(String[] args) throws InterruptedException, IOException {
    String organizationName="afourtechqa";
    String username="test";
    String password="pass";
    LoginPage loginPage=new LoginPage();
    loginPage.login(organizationName,username,password);
  }
}
