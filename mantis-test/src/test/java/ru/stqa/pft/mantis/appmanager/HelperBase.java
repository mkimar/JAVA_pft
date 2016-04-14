package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class HelperBase {
  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase(ApplicationManager app) {
    this.app = app;
    this.wd = app.getDriver();
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

  protected void attach(By lokator, File file) {
    if (file != null) {
      wd.findElement(lokator).sendKeys(file.getAbsolutePath());
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

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
