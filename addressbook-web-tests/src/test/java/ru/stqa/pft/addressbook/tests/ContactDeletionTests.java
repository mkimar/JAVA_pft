package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getContactHelper().allContacts();
    int before = app.getContactHelper().getContactsCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact(new ContactData("JA14032016", "ContactM01", "ContactM02", "ContactM03", "ContactM04",
              "ContactM05", "ContactM06", "ContactM07", "1111111", "ContactM08", "2222222",
              "mkimar@mail.ru", "ContactM09", "TestNULL"), true);
    }
    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().allertDeletionContact();
    app.getContactHelper().allContacts();
    int after = app.getContactHelper().getContactsCount();
    Assert.assertEquals(after,before - 1);



  }

}
