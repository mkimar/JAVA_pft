package kz.stqa.pft.newproect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.Locatable;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ClassUtverghdenieTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://in-capsule.com:9090/Workflow/login");
    login();
  }

  public void login() {
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys("superdev");
    wd.findElement(By.id("pwd")).click();
    wd.findElement(By.id("pwd")).clear();
    wd.findElement(By.id("pwd")).sendKeys("1");
    wd.findElement(By.id("enter")).click();
  }

  @Test
  public void testsClassUtverghdenie() {

    wd.findElement(By.xpath("//ul[@id='navigation']/li[1]/div")).click();
    wd.findElement(By.linkText("Создать бизнес-класс")).click();
    wd.findElement(By.cssSelector("a.arial12green")).click();// клик по процессу Утвердить в Журнале функций

    scrollDown();// скроллинг вниз
    //((Locatable)wd.findElement(By.xpath("//select[@id=\"fDEC_MAKERCB\"]//option[@value=\"35\"]"))).getCoordinates();

    wd.findElement(By.xpath("//select[@id=\"fDEC_MAKERCB\"]//option[@value=\"35\"]")).click();//выбор сотрудника
    wd.findElement(By.id("fREGISTER_DATE")).click();
    wd.findElement(By.id("fEFFECTIVE_DATE")).click();
    wd.findElement(By.linkText("Next")).click();
    wd.findElement(By.linkText("1")).click();

    wd.findElement(By.id("tab-class-classification")).click();
    wd.findElement(By.id("tab-class-properties")).click();
    wd.findElement(By.id("tab-class-solutions")).click();
    wd.findElement(By.id("fdnote")).click();
    wd.findElement(By.id("fdnote")).clear();
    wd.findElement(By.id("fdnote")).sendKeys("okок");
    wd.findElement(By.xpath("select[@id=\"fdecisionid\"]/option[@value=\"4\"]")).click();
    wd.findElement(By.linkText("Выход")).click();
  }

  private void scrollDown() {

    ((JavascriptExecutor) wd).executeScript("window.scrollBy(" + 0 + ","
            + (-8) + ");");
  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
