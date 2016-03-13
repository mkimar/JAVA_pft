package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().newContactCreationPage();
    app.getContactHelper().fillContactForm(new ContactData("ASTOR14032016", "ContactM02", "ContactM03", "ContactM04", "ContactM05",
            "ContactM06", "ContactM07", "ContactM08", "1111111", "ContactM09", "2222222",
            "mkimar@mail.ru", "ContactM10", "TestNULL"), true);
    app.getContactHelper().submitContactForm();
    app.getSessionHelper().logout();


  }


}
