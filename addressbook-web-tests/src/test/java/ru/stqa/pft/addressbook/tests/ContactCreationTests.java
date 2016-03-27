package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test//(enabled = false)
  public void testContactCreation() {
    app.contact().contactsPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/mmk1.png");
    ContactData contact = new ContactData()
            .withLname("NICOLAEVAS2").withFname("SONIAS2").withPhoto(photo).withGroup("TestNULL");
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

