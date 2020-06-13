package com.general.reporting.examples;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.general.reporting.ExtentReporter;
import com.web.pageobjectModel.CustomWebDriver;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class BasicReportImplementation {

  public static void main(String[] args) throws IOException, InterruptedException {
    WebDriver driver=new CustomWebDriver().getDriver();
    //driver.manage().window().maximize();;
    driver.get("https://www.google.com/");
    Thread.sleep(3000);

    ExtentReports extentReporter=new ExtentReporter().initReporter();
    ExtentTest nodeTest=extentReporter.createTest(" User LOGIN");
    nodeTest
        .assignAuthor("Kingshuk Nandy")
        .assignCategory("Regression")
        .assignDevice("Web-Application");
    nodeTest.fail("User Logged in Successfully", MediaEntityBuilder.createScreenCaptureFromPath(CustomWebDriver.takesScreenhot()).build());
    extentReporter.flush();
    driver.close();
    driver.quit();
  }

}
