package kz.stqa.pft.newproect;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ClassCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://in-capsule.com:9090/Workflow/login");
    login();
  }

  private void login() {
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys("user1");
    wd.findElement(By.id("pwd")).click();
    wd.findElement(By.id("pwd")).clear();
    wd.findElement(By.id("pwd")).sendKeys("1");
    wd.findElement(By.id("enter")).click();
  }

  @Test
  public void testClassCreation() {
    wd.findElement(By.xpath("//ul[@id='navigation']/li[1]/div")).click();
    wd.findElement(By.xpath("//b[text()=\"Создать бизнес-класс\"]")).click();
    wd.findElement(By.linkText("создать")).click();
    wd.switchTo().alert().accept();
    //wd.findElement(By.id("ufd-npa_select")).click();
    //new Select(wd.findElement(By.name("npa_select"))).selectByValue("1");
    wd.findElement(By.id("close_npa")).click();
    wd.findElement(By.id("ufd-fSECURITY_ID")).click();
    new Select(wd.findElement(By.id("fSECURITY_ID"))).selectByVisibleText("Открытая Информация");
    wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[@value=\"2\"]")).click();
    wd.findElement(By.id("fCLASS_NAME")).click();
    wd.findElement(By.id("fCLASS_NAME")).clear();
    wd.findElement(By.id("fCLASS_NAME")).sendKeys("Куртки");
    wd.findElement(By.id("fTARGET")).click();
    wd.findElement(By.id("fTARGET")).clear();
    wd.findElement(By.id("fTARGET")).sendKeys("Учет");
    wd.findElement(By.id("fANALITIC_VALUE")).click();
    wd.findElement(By.id("fANALITIC_VALUE")).clear();
    wd.findElement(By.id("fANALITIC_VALUE")).sendKeys("Контроль");
    wd.findElement(By.id("fDESCRIPTION")).click();
    wd.findElement(By.id("fDESCRIPTION")).clear();
    wd.findElement(By.id("fDESCRIPTION")).sendKeys("Куртки-это удобно");
    wd.findElement(By.id("fEFFECTIVE_DATE")).click();
    wd.findElement(By.xpath("//span[contains(text(),\"След\")]"));
    //wd.findElement(By.linkText("Next")).click();
    wd.findElement(By.linkText("28")).click();
    scrollTop();// скроллинг вверх
    wd.findElement(By.xpath("//a[@id='tab-class-classification']")).click();
    wd.findElement(By.xpath("//input[@id='fBASECLASS']")).click();//клик для открытия дерева
    wd.findElement(By.xpath("//span[@class=\"dynatree-expander\"]")).click();// раскрытие дерева
    wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/span/span[1]")).click();//расрытие дерева Товар
    wd.findElement(By.xpath("//div[@id='tCLASSTREE']/ul/li/ul/li[2]/ul/li[2]/span/span[1]")).click();//расрытие дерева Одежда
    wd.findElement(By.xpath("//a[text()=\"ВЕРХНЯЯ ОДЕЖДА\"]")).click();
    wd.findElement(By.id("tab-class-properties")).click();
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//tr[@id='propedit_tr_new']/td[3]"))).build().perform();
    wd.findElement(By.id("edit_prop_attrname")).click();
    wd.findElement(By.id("edit_prop_attrname")).clear();
    wd.findElement(By.id("edit_prop_attrname")).sendKeys("Пуговицы123");
    wd.findElement(By.id("ufd-edit_fldtype")).click();
    //new Select(wd.findElement(By.id("edit_fldtype"))).selectByVisibleText("Вещественный");
    wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[@value=\"1\"]")).click();
    wd.findElement(By.id("edit_prop_mask")).click();
    wd.findElement(By.id("edit_prop_mask")).clear();
    wd.findElement(By.id("edit_prop_mask")).sendKeys("чч");
    wd.findElement(By.id("edit_prop_limits")).click();
    wd.findElement(By.id("edit_prop_limits")).clear();
    wd.findElement(By.id("edit_prop_limits")).sendKeys("1");
    wd.findElement(By.id("edit_prop_restriks")).click();
    wd.findElement(By.id("edit_prop_restriks")).clear();
    wd.findElement(By.id("edit_prop_restriks")).sendKeys("2");
    wd.findElement(By.id("edit_prop_defval")).click();
    wd.findElement(By.id("edit_prop_defval")).clear();
    wd.findElement(By.id("edit_prop_defval")).sendKeys("3");
    //wd.findElement(By.id("ufd-edit_prop_seculev")).click();
    //new Select(wd.findElement(By.id("edit_prop_seculev"))).selectByVisibleText("Открытая Информация");
    wd.findElement(By.xpath("//select[@id='edit_prop_seculev']//option[@value=\"3\"]")).click();
    wd.findElement(By.id("edit_prop_attrdescr")).click();
    wd.findElement(By.id("edit_prop_attrdescr")).clear();
    wd.findElement(By.id("edit_prop_attrdescr")).sendKeys("4");

    scrollRight(); //

    wd.findElement(By.id("edit_prop_attrdata")).click();//не находит этот элемент
    wd.findElement(By.linkText("Next")).click();
    wd.findElement(By.linkText("5")).click();
    wd.findElement(By.id("edit_prop_note")).click();
    wd.findElement(By.id("edit_prop_note")).clear();
    wd.findElement(By.id("edit_prop_note")).sendKeys("5");
    wd.findElement(By.id("edit_save")).click();
    wd.findElement(By.id("tab-class-solutions")).click();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).click();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).clear();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).sendKeys("куртка ага");
    wd.findElement(By.id("saveProfile")).click();
    wd.findElement(By.id("sendProfile")).click();
    wd.findElement(By.linkText("Выход")).click();
  }

  public void scrollRight() {

    ((JavascriptExecutor) wd).executeScript("window.scrollBy(" + 60 + ","
            + 0 + ");");
  }

  private void scrollTop() {
    JavascriptExecutor js = (JavascriptExecutor) wd;
    js.executeScript("window.scrollTo(0, 0);");
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
