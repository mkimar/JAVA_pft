package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test

  public void testContactModification(){

    app.getContactHelper().allContacts();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ModificContact1", "ContactM02", "ContactM03", "ContactM04", "ContactM05", "ContactM06", "ContactM07", "ContactM08", "1111111", "ContactM09", "2222222", "mkimar@mail.ru", "ContactM10"));
    app.getContactHelper().submitContactModification();
  }

}
