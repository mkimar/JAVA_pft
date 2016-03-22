package kz.stqa.pft.newproect;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ClassUtverghdenieTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().window().maximize();
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

    wd.findElement(By.xpath("//ul[@id='navigation']/li[1]/div")).click();//Управление бизнес-классами
    wd.findElement(By.linkText("Создать бизнес-класс")).click();
    //wd.findElement(By.cssSelector("a.arial12green")).click();// клик по новому процессу Утвердить в Журнале функций
    wd.findElement(By.cssSelector("a.arial12black")).click();// клик по просмотренному процессу Утвердить в Журнале функций

    if (!wd.findElement(By.xpath("//select[@id='fOWNER_IDCB']//option[2]")).isSelected()) {  //Выбор владельца класса
      wd.findElement(By.xpath("//select[@id='fOWNER_IDCB']//option[2]")).click();           //Выбор владельца класса
    }                                                                                       //Выбор владельца класса

    wd.findElement(By.id("ufd-fDEC_MAKERCB")).click();                                            //Лицо ответ-ое
    if (!wd.findElement(By.xpath("//div[@id='ufd-container']//li[@name=\"13\"]")).isSelected()) { //Лицо ответ-ое
      wd.findElement(By.xpath("//div[@id='ufd-container']//li[@name=\"13\"]")).click();           //Лицо ответ-ое
    }                                                                                             //Лицо ответ-ое

    wd.findElement(By.id("tab-class-classification")).click(); //Классификация
    wd.findElement(By.id("tab-class-properties")).click();     //Свойства
    wd.findElement(By.id("tab-class-solutions")).click();      //Решения
    wd.findElement(By.id("fdnote")).click();          //Особое мнение
    wd.findElement(By.id("fdnote")).clear();          //Особое мнение
    wd.findElement(By.id("fdnote")).sendKeys("ококок");//Особое мнение
    wd.findElement(By.id("ufd-fdecisionid")).click(); //выбор решения
    wd.findElement(By.xpath("//div[@id='ufd-container']//li[text()='Утверждено']")).click();

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
