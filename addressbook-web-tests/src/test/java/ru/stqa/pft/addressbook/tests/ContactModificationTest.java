package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.contact().contactsPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withLname("S01").withFname("S02").withMname("S03").withNickname("D01").withGroup("TestNULL"), true);
    }
  }

  @Test //(enabled = false)

  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withLname("Mod_DA").withFname("NO").withMname("REWA");
    app.contact().modify(contact);
    assertThat(app.group().count(), equalTo(before.size()));//проверка количества элементов в группах до и после
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));//сравнение групп по имени
  }


}
