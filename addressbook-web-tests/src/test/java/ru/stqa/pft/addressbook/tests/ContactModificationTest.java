package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test

  public void testContactModification() {

    app.getContactHelper().allContacts();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact(new ContactData("JA14032016", "ContactM01", "ContactM02", "ContactM03", "ContactM04",
              "ContactM05", "ContactM06", "ContactM07", "1111111", "ContactM08", "2222222",
              "mkimar@mail.ru", "ContactM09", "TestNULL"), true);
    }
    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ModC_14032016", "JA14032016", "ContactKKKKK", null, "ContactM05",
            "ContactM06", "ContactM07", null, "1111111", "ContactM09", "2222222", null, "ContactM10", null), false);
    app.getContactHelper().submitContactModification();
  }

}
