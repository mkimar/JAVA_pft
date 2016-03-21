package kz.stqa.pft.newproect;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AnalyzeTest {


  public static void main(String[] args) throws Exception {
    FirefoxDriver wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("http://in-capsule.com:9090/Workflow/login");
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys("user2");
    wd.findElement(By.id("pwd")).click();
    wd.findElement(By.id("pwd")).clear();
    wd.findElement(By.id("pwd")).sendKeys("1");
    wd.findElement(By.id("enter")).click();
    wd.findElement(By.xpath("//li/div")).click(); // Открыть плюсик в меню Управление бизнес-классами
    wd.findElement(By.xpath("//a[@class='prmenu']/b[text()='Анализ свойств классов']")).click();// Кликнуть по Анализ свойств классов
    wd.findElement(By.xpath("//div[@id='tCLASSATTRTREE']/ul/li/span/span")).click(); // Открыть дерево классов щелкнув по плюсику
    wd.findElement(By.xpath("//a[contains(text(),'УСЛУГИ')]")).click();// Выбрать необходимый класс для просмотра
    // и пройтись по вкладкам
    screenPage();// скриншот страницы
    wd.findElement(By.id("tab-class-classification")).click();//Классификация
    screenPage();// скриншот страницы
    wd.findElement(By.xpath("//a[@id='tab-class-properties']")).click(); // Свойства класса
    screenPage();// скриншот страницы
    wd.findElement(By.id("tab-class-solutions")).click();//Решения
    screenPage();// скриншот страницы
    wd.findElement(By.id("tab-class-use")).click();//Использование
    screenPage();// скриншот страницы
    wd.findElement(By.xpath("//a[@id='tab-class-chjournal']")).click(); // Журнал изменений
    screenPage();// скриншот страницы
    wd.findElement(By.xpath("//button[@id='closeProfile']")).click();// На панели действий нажать Отложить

  }

  public static void screenPage() throws IOException {
    FirefoxDriver wd = new FirefoxDriver();
    File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
    String path = "c:/Users/marina/Downloads/" + screenshot.getName();
    FileUtils.copyFile(screenshot, new File(path));
  }


  public static void tearDown() {
    FirefoxDriver wd = new FirefoxDriver();
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
