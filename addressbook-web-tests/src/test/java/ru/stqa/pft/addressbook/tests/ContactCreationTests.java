package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().allContacts();
    int before = app.getContactHelper().getContactsCount();
    app.getContactHelper().creatContact(new ContactData("JA14032016", "ContactM", "ContactM05", "ContactM03", "ContactM04",
            "ContactM05", "ContactM06", "ContactM07", "1111111", "ContactM08", "2222222",
            "mk@mail.ru", "ContactM09", "TestNULL"), true);
    app.getContactHelper().allContacts();
    int after = app.getContactHelper().getContactsCount();
    Assert.assertEquals(after,before + 1);


  }


}
