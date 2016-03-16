package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().creatContact(new ContactData("JA14032016", "ContactM", "ContactM04", "ContactM03", "ContactM04",
            "ContactM05", "ContactM06", "ContactM07", "1111111", "ContactM08", "2222222",
            "mk@mail.ru", "ContactM09", "Test02"), true);
    app.getSessionHelper().logout();


  }


}
