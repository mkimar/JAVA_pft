package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test(enabled = false)

  public void testContactModification() {

    app.getContactHelper().allContacts();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact(new ContactData("S01", "S02", "S03", "D01", "TestNULL"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Mod_DA", "NO", "REWA",
            null, null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().allContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    //Comparator<? super ContactData> byId = (g1, g2)-> Integer.compare(g1.getId(),g2.getId());
    //before.sort(byId);
    //after.sort(byId);
    Assert.assertEquals(before,  after);
  }

}
