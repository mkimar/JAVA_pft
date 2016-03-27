package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/mmk1.png");
    list.add(new Object[]{new ContactData().withLname("lname01").withFname("fname01").withPhoto(photo).withGroup("TestNULL")});
    list.add(new Object[]{new ContactData().withLname("lname02").withFname("fname02").withPhoto(photo).withGroup("TestNULL")});
    list.add(new Object[]{new ContactData().withLname("lname03").withFname("fname03").withPhoto(photo).withGroup("TestNULL")});
    return list.iterator();
  }


  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.contact().contactsPage();
    Contacts before = app.contact().all();
    app.contact().create(contact, true);
    app.contact().contactsPage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));//сравнение кол-ва элементов до и после
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));//сравнение данных до и после


  }

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/mmk1.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }


}

