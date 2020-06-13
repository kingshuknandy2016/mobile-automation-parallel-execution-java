package com.general.utils;

import com.mobile.android.pageobject.CustomMobileDriver;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotUtils {

  public static String takesScreenhot() {
    String path = "";
    /*
     * String encodedBase64 = null; FileInputStream fileInputStreamReader = null;
     */
    try {
      File sourcePath = ((TakesScreenshot) new CustomMobileDriver().getAppiumDriver()).getScreenshotAs(OutputType.FILE);
      System.out.println("SOURCE PATH: "+sourcePath);
      path = System.getProperty("user.dir") + File.separator + "reportsandlogs" + File.separator + "screenshots"
          + File.separator + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".png";
      File destinationPath = new File(path);
      Files.copy(sourcePath, destinationPath);
      System.out.println("DESTINATION PATH: "+destinationPath);
      /*
       * fileInputStreamReader = new FileInputStream(sourcePath); byte[] bytes = new
       * byte[(int) sourcePath.length()]; fileInputStreamReader.read(bytes);
       * encodedBase64 = new String(Base64.encodeBase64(bytes));
       */

    } catch (IOException e) {
      System.out.println("Error occured while execution of takescreenshot object");
      System.out.println("Exception:" + e.getLocalizedMessage());
    }
    /* return "data:image/png;base64," + encodedBase64; */
    return path;
  }
}
