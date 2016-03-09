package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By lokator) {
    wd.findElement(lokator).click();
  }

  protected void type(By lokator, String text) {
    click(lokator);
    if (text != null) {
      String existingText = wd.findElement(lokator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(lokator).clear();
        wd.findElement(lokator).sendKeys(text);
      }
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
