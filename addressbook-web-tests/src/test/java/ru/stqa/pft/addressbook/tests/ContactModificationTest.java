package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.contact().contactsPage();
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData()
              .withLname("S01").withFname("S02").withMname("S03").withNickname("D01").withGroup("TestNULL"), true);
    }
  }

  @Test //(enabled = false)

  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData()
            .withId(before.get(before.size() - 1).getId()).withLname("Mod_DA").withFname("NO").withMname("REWA");
    app.contact().modify(before, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    //Comparator<? super ContactData> byId = (g1, g2)-> Integer.compare(g1.getId(),g2.getId());
    //before.sort(byId);
    //after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
