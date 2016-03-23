package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion() {
    app.getContactHelper().allContacts();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact(new ContactData().withLname("ContactM01").withFname("ContactM02")
              .withMname("ContactM03").withNickname("ContactM04").withGroup("TestNULL"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().allertDeletionContact();
    app.getContactHelper().allContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}
