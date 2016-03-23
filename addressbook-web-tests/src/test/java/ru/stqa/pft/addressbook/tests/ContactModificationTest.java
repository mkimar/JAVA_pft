package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withLname("Mod_DA").withFname("NO").withMname("REWA");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
