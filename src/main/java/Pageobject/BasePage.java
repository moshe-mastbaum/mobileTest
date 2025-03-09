package Pageobject;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BasePage {
   //    Attributes
    static AndroidDriver driver;
   //    constructor
    public BasePage(AndroidDriver driver){
        this.driver=driver;
    }

  // functions

  public void click(By element){
        driver.findElement(element).click();
  }

  public String getText(By element){
      return  driver.findElement(element).getText();
  }


}
