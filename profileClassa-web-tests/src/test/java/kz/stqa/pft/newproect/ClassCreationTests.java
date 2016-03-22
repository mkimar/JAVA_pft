package kz.stqa.pft.newproect;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ClassCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().window().maximize();
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
    wd.findElement(By.xpath("//ul[@id='navigation']/li[1]/div")).click();//Раскрыть плюс Управление бизнес-классами
    wd.findElement(By.xpath("//b[text()=\"Создать бизнес-класс\"]")).click();//Раскрыть Создать бизнес-класс
    wd.findElement(By.linkText("создать")).click();// Создать новый Профиль класса
    wd.switchTo().alert().accept();// в информац.сообщении щелкнуть ОК

    wd.findElement(By.id("ufd-npa_select")).click();  //Выбор НПА
    wd.findElement(By.xpath("//div[@id='ufd-container']/div[2]//li[2]")).click(); //Выбор НПА
    if (!wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).isSelected()) {  //Выбор НПА
      wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).click();
    }  //Выбор НПА
    wd.findElement(By.id("close_npa")).click(); // Далее

    wd.findElement(By.id("ufd-fSECURITY_ID")).click();//вкладка Описание. Выбор уровня секретности
    wd.findElement(By.name("7")).click();//"Открытая Информация"
    if (!wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[8]")).isSelected()) {//Выбор уровня секретности
      wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[8]")).click();//Выбор уровня секретности
    }//Выбор уровня секретности
    wd.findElement(By.id("saveProfile")).click();//Сохранить
    //new Select(wd.findElement(By.id("fSECURITY_ID"))).selectByVisibleText("Открытая Информация"); почему-то этот код не работает!!!
    wd.findElement(By.id("fCLASS_NAME")).click();//Имя класса
    wd.findElement(By.id("fCLASS_NAME")).clear();//Имя класса
    wd.findElement(By.id("fCLASS_NAME")).sendKeys("КурткиАвтотест05");//Имя класса
    wd.findElement(By.id("fTARGET")).click(); //Цель создания класса
    wd.findElement(By.id("fTARGET")).clear();//Цель создания класса
    wd.findElement(By.id("fTARGET")).sendKeys("Учет");//Цель создания класса
    wd.findElement(By.id("fANALITIC_VALUE")).click();//Аналитическая/эксплуатационная полезность (ценность) класса
    wd.findElement(By.id("fANALITIC_VALUE")).clear();//Аналитическая/эксплуатационная полезность (ценность) класса
    wd.findElement(By.id("fANALITIC_VALUE")).sendKeys("Контроль");//Аналитическая/эксплуатационная полезность (ценность) класса
    wd.findElement(By.id("fDESCRIPTION")).click();//Описание класса
    wd.findElement(By.id("fDESCRIPTION")).clear();//Описание класса
    wd.findElement(By.id("fDESCRIPTION")).sendKeys("КурткиАвтотест02-это удобно");//Описание класса
    wd.findElement(By.id("fEFFECTIVE_DATE")).click();//Дата вступления в силу
    wd.findElement(By.xpath("//span[contains(text(),\"След\")]"));//Дата вступления в силу
    wd.findElement(By.linkText("28")).click();//Дата вступления в силу
    wd.findElement(By.id("saveProfile")).click();//Сохранить
    scrollTop();// скроллинг вверх

    wd.findElement(By.xpath("//a[@id='tab-class-classification']")).click();// вкладка Классификация
    wd.findElement(By.xpath("//input[@id='fBASECLASS']")).click();//клик для открытия дерева
    wd.findElement(By.xpath("//span[@class=\"dynatree-expander\"]")).click();// раскрытие дерева
    wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[2]/span/span[1]")).click();//расрытие дерева Товар
    wd.findElement(By.xpath("//div[@id='tCLASSTREE']/ul/li/ul/li[2]/ul/li[2]/span/span[1]")).click();//расрытие дерева Одежда
    wd.findElement(By.xpath("//a[text()=\"ВЕРХНЯЯ ОДЕЖДА\"]")).click();//Выбор базового класса

    wd.findElement(By.id("tab-class-properties")).click();// вкладка Свойства
    new Actions(wd).doubleClick(wd.findElement(By.xpath("//tr[@id='propedit_tr_new']/td[3]"))).build().perform();//клик
    // по строке для создания атрибута
    wd.findElement(By.id("edit_prop_attrname")).click();//Название атрибута
    wd.findElement(By.id("edit_prop_attrname")).clear();//Название атрибута
    wd.findElement(By.id("edit_prop_attrname")).sendKeys("Атрибут номер 1");//Название атрибута
    wd.findElement(By.id("saveProfile")).click();//Сохранить
    //выбор типа поля
    wd.findElement(By.id("ufd-edit_fldtype")).click();//Тип поля
    wd.findElement(By.xpath("//div[@id='ufd-container']//li[.='Символьный']")).click();//Тип поля
    if (!wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[6]")).isSelected()) {//Тип поля
      wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[6]")).click();//Тип поля
    }//Тип поля
    wd.findElement(By.id("edit_prop_mask")).click();//Формат/ маска поля
    wd.findElement(By.id("edit_prop_mask")).clear();//Формат/ маска поля
    wd.findElement(By.id("edit_prop_mask")).sendKeys("NNSSSS");//Формат/ маска поля
    wd.findElement(By.id("saveProfile")).click();//Сохранить
    wd.findElement(By.id("edit_prop_limits")).click();//Ограничения (разрешенные значения)
    wd.findElement(By.id("edit_prop_limits")).clear();//Ограничения (разрешенные значения)
    wd.findElement(By.id("edit_prop_limits")).sendKeys("0");//Ограничения (разрешенные значения)
    //wd.findElement(By.id("edit_prop_restriks")).click();
    //wd.findElement(By.id("edit_prop_restriks")).clear();
    //wd.findElement(By.id("edit_prop_restriks")).sendKeys("2");
    wd.findElement(By.id("edit_prop_defval")).click();//Значение по-умолчанию
    wd.findElement(By.id("edit_prop_defval")).clear();//Значение по-умолчанию
    wd.findElement(By.id("edit_prop_defval")).sendKeys("1");//Значение по-умолчанию
    wd.findElement(By.id("ufd-edit_prop_seculev")).click();//Уровень секретности
    wd.findElement(By.xpath("//div[@id='ufd-container']/div[3]/div/div/ul/li[3]")).click();//Уровень секретности
    if (!wd.findElement(By.xpath("//select[@id='edit_prop_seculev']//option[3]")).isSelected()) {//Уровень секретности
      wd.findElement(By.xpath("//select[@id='edit_prop_seculev']//option[3]")).click();//Уровень секретности
    }//Уровень секретности
    wd.findElement(By.id("saveProfile")).click();//Сохранить
    wd.findElement(By.id("edit_prop_attrdescr")).click();//Описание атрибута
    wd.findElement(By.id("edit_prop_attrdescr")).clear();//Описание атрибута
    wd.findElement(By.id("edit_prop_attrdescr")).sendKeys("Первый атрибут");//Описание атрибута
    //scrollRight(); //
    wd.findElement(By.id("edit_prop_attrdate")).click();//Дата вступления в силу
    wd.findElement(By.linkText("След>")).click();//Дата вступления в силу
    wd.findElement(By.linkText("След>")).click();//Дата вступления в силу
    wd.findElement(By.linkText("10")).click();//Дата вступления в силу
    wd.findElement(By.id("edit_prop_note")).click();//Примечание
    wd.findElement(By.id("edit_prop_note")).clear();//Примечание
    wd.findElement(By.id("edit_prop_note")).sendKeys("примечание01");//Примечание
    wd.findElement(By.id("edit_save")).click();//Сохранить строку
    wd.findElement(By.id("edit_save")).click();//Сохранить строку

    wd.findElement(By.id("tab-class-solutions")).click();//вкладка Решения
    wd.findElement(By.id("fEXPLANATORY_NOTE")).click();//пояснительная записка
    wd.findElement(By.id("fEXPLANATORY_NOTE")).clear();//пояснительная записка
    wd.findElement(By.id("fEXPLANATORY_NOTE")).sendKeys("автотест пояснительная записка");//пояснительная записка
    wd.findElement(By.id("saveProfile")).click();//Сохранить профиль
    wd.findElement(By.id("sendProfile")).click();//Отправить

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
