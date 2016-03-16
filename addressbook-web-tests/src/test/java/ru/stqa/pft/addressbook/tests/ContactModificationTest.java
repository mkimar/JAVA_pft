package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test

  public void testContactModification() {

    app.getContactHelper().allContacts();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact(new ContactData("S01", "S02", "S03", "D01", "D02",
              "D03", "D04", "D05", "7452", "D06", "564","ar@mail.ru", "Con9", "TestNULL"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Mod_16032016", "JA16032016", "Mobil01",
            null, null, "ContactM06", "ContactM07", null, null, "ContactM09", null, null, "Con555", null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().allContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<ContactData>(before), new HashSet<ContactData>(after));
  }

}
