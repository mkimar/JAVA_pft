package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {


  @Test//(enabled = false)
  public void testContactCreation() {
    app.contact().contactsPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withLname("NICOL").withFname("IVOLGA").withMname("ASTRAL").withNickname("ardo").withGroup("TestNULL");
    app.contact().create(contact, true);
    app.contact().contactsPage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);


  }


}
