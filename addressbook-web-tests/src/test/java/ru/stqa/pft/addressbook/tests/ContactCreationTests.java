package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test//(enabled = false)
  public void testContactCreation() {
    app.contact().contactsPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withLname("NICOL").withFname("IVOLGA").withMname("ASTRAL").withGroup("TestNULL");
    app.contact().create(contact, true);
    app.contact().contactsPage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));//сравнение кол-ва элементов до и после
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));//сравнение данных до и после


  }


}
