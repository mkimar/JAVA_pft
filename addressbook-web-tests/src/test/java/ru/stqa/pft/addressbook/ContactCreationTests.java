package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{


  @Test
  public void testContactCreation() {
    newContactCreationPage();
    fillContactForm(new ContactData("ContactM01", "ContactM02", "ContactM03", "ContactM04", "ContactM05", "ContactM06", "ContactM07", "ContactM08", "1111111", "ContactM09", "2222222", "mkimar@mail.ru", "ContactM10"));
    submitContactForm();
    logout();

  }


}
