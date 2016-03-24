package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.contact().contactsPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withLname("S01").withFname("S02").withMname("S03").withNickname("D01").withGroup("TestNULL"), true);
    }
  }

  @Test //(enabled = false)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));

    assertThat(after, equalTo(before.withOut(deletedContact)));

  }


}
