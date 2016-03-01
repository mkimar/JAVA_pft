package kz.stqa.pft.newproect;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

import static org.openqa.selenium.OutputType.*;

public class ClassCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    wd.get("http://212.42.103.149:8070/Workflow/login");
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
    wd.findElement(By.xpath("//ul[@id='navigation']/li[2]/div")).click();
    wd.findElement(By.xpath("//ul[@id='navigation']/li[2]/div")).click();
    wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
    wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
    wd.findElement(By.linkText("создать")).click();
    wd.switchTo().alert().accept();
    if (!wd.findElement(By.xpath("//div[@id='choose_npa']/table/tbody/tr[1]/td[2]/select//option[3]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='choose_npa']/table/tbody/tr[1]/td[2]/select//option[3]")).click();
    }
    wd.findElement(By.id("close_npa")).click();
    if (!wd.findElement(By.xpath("//div[@id='divdescription']/div[6]/select//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='divdescription']/div[6]/select//option[8]")).click();
    }
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
    wd.findElement(By.id("tab-class-classification")).click();
    wd.findElement(By.id("fBASECLASS")).click();
    wd.findElement(By.cssSelector("span.dynatree-expander")).click();
    wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/span/span[1]")).click();
    wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/ul/li[2]/span/span[1]")).click();
    wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/ul/li[2]/ul/li[2]/span/span[1]")).click();
    wd.findElement(By.linkText("ВЕРХНЯЯ ОДЕЖДА")).click();
    wd.findElement(By.id("tabs-class-classification")).click();
    wd.findElement(By.id("tab-class-properties")).click();
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//tr[@id='propedit_tr_new']/td[3]"))).build().perform();
    wd.findElement(By.id("edit_prop_attrname")).click();
    wd.findElement(By.id("edit_prop_attrname")).clear();
    wd.findElement(By.id("edit_prop_attrname")).sendKeys("Пуговицы");
    wd.findElement(By.cssSelector("button.print-unvisible.hover")).click();
    wd.findElement(By.xpath("//div[@id='ufd-container']//li[.='Строковый']")).click();
    if (!wd.findElement(By.xpath("//tr[@id='propedit_tr_1']/td[4]/div/span/select//option[7]")).isSelected()) {
      wd.findElement(By.xpath("//tr[@id='propedit_tr_1']/td[4]/div/span/select//option[7]")).click();
    }
    wd.findElement(By.id("edit_prop_mask")).click();
    wd.findElement(By.id("edit_prop_mask")).clear();
    wd.findElement(By.id("edit_prop_mask")).sendKeys("чч");
    wd.findElement(By.id("edit_prop_limits")).click();
    wd.findElement(By.id("edit_prop_limits")).clear();
    wd.findElement(By.id("edit_prop_limits")).sendKeys("1");
    wd.findElement(By.xpath("//tr[@id='propedit_tr_1']/td[7]")).click();
    wd.findElement(By.id("edit_prop_restriks")).click();
    wd.findElement(By.id("edit_prop_restriks")).clear();
    wd.findElement(By.id("edit_prop_restriks")).sendKeys("2");
    wd.findElement(By.id("edit_prop_defval")).click();
    wd.findElement(By.id("edit_prop_defval")).clear();
    wd.findElement(By.id("edit_prop_defval")).sendKeys("3");
    wd.findElement(By.cssSelector("button.print-unvisible.hover")).click();
    wd.findElement(By.name("7")).click();
    if (!wd.findElement(By.xpath("//tr[@id='propedit_tr_1']/td[9]/span/select//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//tr[@id='propedit_tr_1']/td[9]/span/select//option[8]")).click();
    }
    wd.findElement(By.id("edit_prop_attrdescr")).click();
    wd.findElement(By.id("edit_prop_attrdescr")).clear();
    wd.findElement(By.id("edit_prop_attrdescr")).sendKeys("ааа");
    wd.findElement(By.id("edit_prop_attrdate")).click();
    wd.findElement(By.linkText("23")).click();
    wd.findElement(By.id("edit_save")).click();
    wd.findElement(By.id("tab-class-solutions")).click();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).click();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).clear();
    wd.findElement(By.id("fEXPLANATORY_NOTE")).sendKeys("куртка ага");
    wd.findElement(By.id("saveProfile")).click();
    wd.findElement(By.id("sendProfile")).click();
    wd.findElement(By.linkText("Выход")).click();
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
