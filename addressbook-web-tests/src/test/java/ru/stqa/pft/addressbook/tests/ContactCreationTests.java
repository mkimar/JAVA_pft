package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test(enabled = false)
  public void testContactCreation() {
    app.getContactHelper().allContacts();
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData()
            .withLname("NICOL").withFname("IVOLGA").withMname("ASTRAL").withNickname("ardo").withGroup("TestNULL");
    app.getContactHelper().creatContact(contact, true);
    app.getContactHelper().allContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);

    //before.add(contact);
    //Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    //before.sort(byId);
    //after.sort(byId);
   //Assert.assertEquals(before, after);



  }


}
