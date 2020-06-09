package com.pageobject;

import com.pageobject.pages.LoginPage;

public class TestSuite1 {

  public static void main(String[] args) throws InterruptedException {

    String username="test";
    String password="pass";
    LoginPage loginPage=new LoginPage();
    loginPage.login(username,password);
  }
}
