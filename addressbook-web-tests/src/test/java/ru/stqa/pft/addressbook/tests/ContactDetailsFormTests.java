package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class ContactDetailsFormTests extends TestBase {

  @Test
  public void testContactDetailsForm() {

    app.contact().contactsPage();
    ContactData contact = app.contact().all01().iterator().next();
    ContactData contactDetailsForm = app.contact().contactDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);
   // assertEquals(contactDetailsForm.getFname(), mergeNames(contactInfoFromEditForm));
    assertEquals(contactDetailsForm.getNickname(), contactInfoFromEditForm.getNickname());
    assertEquals(contactDetailsForm.getTitle(), contactInfoFromEditForm.getTitle());
    assertEquals(contactDetailsForm.getCompany(), contactInfoFromEditForm.getCompany());
    assertEquals(contactDetailsForm.getAddress(), contactInfoFromEditForm.getAddress());
    assertEquals(cleaned(contactDetailsForm.getHome()), contactInfoFromEditForm.getHome());
    assertEquals(cleaned(contactDetailsForm.getMobile()), contactInfoFromEditForm.getMobile());
    assertEquals(cleaned(contactDetailsForm.getWork()), contactInfoFromEditForm.getWork());
    assertEquals(cleaned(contactDetailsForm.getFax()), contactInfoFromEditForm.getFax());
    //assertEquals(contactDetailsForm.getEmail(), contactInfoFromEditForm.getEmail());
    assertEquals(contactDetailsForm.getEmail2(), contactInfoFromEditForm.getEmail2());
    // assertEquals(contactDetailsForm.getEmail3(),contactInfoFromEditForm.getEmail3());
    assertEquals(contactDetailsForm.getHomepage(), contactInfoFromEditForm.getHomepage());
    assertEquals(cleaned(contactDetailsForm.getPhone2()), contactInfoFromEditForm.getPhone2());
    assertEquals(contactDetailsForm.getNotes(), contactInfoFromEditForm.getNotes());
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[:HMWFP]", "");
  }

  private String mergeNames(ContactData contact) {
    return  Arrays.asList(contact.getFname(),contact.getMname(),contact.getLname())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));

  }

}
