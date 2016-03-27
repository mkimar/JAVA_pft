package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/mmk1.png");
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new ContactData().withFname(split[0]).withLname(split[1]).withGroup(split[2]).withPhoto(photo)});
      line = reader.readLine();
    }
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

