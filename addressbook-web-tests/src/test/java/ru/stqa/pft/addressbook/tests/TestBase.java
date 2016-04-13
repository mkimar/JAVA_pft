package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList());
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() { // сравнение списка групп из базы данных со списком групп в интерфейсе

    if (Boolean.getBoolean("verifyUI")) { // для включения данной проверки необходимо в параметрах указать: -DverifyUI=true
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }

  }

  public void verifyContactListInUI() { // сравнение списка контактов из базы данных со списком контактов в интерфейсе

    if (Boolean.getBoolean("verifyUI")) { // для включения данной проверки необходимо в параметрах указать: -DverifyUI=true
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData().withId(g.getId()).withMname(g.getMname()).withPhoto(g.getPhoto())
                      .withGroup(g.getGroup()).withTitle(g.getTitle()).withNickname(g.getNickname())
                      .withAddress2(g.getAddress2()).withCompany(g.getCompany()).withEmail(g.getEmail())
                      .withEmail2(g.getEmail2()).withEmail3(g.getEmail3()).withFax(g.getFax())
                      .withHomepage(g.getHomepage()).withNotes(g.getNotes()).withPhone2(g.getPhone2()))
              .collect(Collectors.toSet())));
    }

  }

}
