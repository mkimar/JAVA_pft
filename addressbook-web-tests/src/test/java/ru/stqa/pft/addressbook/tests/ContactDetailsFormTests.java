package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactDetailsFormTests extends TestBase {

  @Test
  public void testContactDetailsForm() {

    app.contact().contactsPage();
    ContactData contact = app.contact().all01().iterator().next();
    ContactData contactDetailsForm = app.contact().contactDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);
    assertEquals(contactDetailsForm.getNickname(), contactInfoFromEditForm.getNickname());
    assertThat(contactDetailsForm.getFname(), equalTo(mergeNames(contactInfoFromEditForm)));
    assertEquals(contactDetailsForm.getTitle(), contactInfoFromEditForm.getTitle());
    assertEquals(contactDetailsForm.getCompany(), contactInfoFromEditForm.getCompany());
    assertEquals(contactDetailsForm.getAddress(), contactInfoFromEditForm.getAddress());
    assertEquals(cleaned01(contactDetailsForm.getHome()), cleaned01(contactInfoFromEditForm.getHome()));
    assertEquals(cleaned01(contactDetailsForm.getMobile()), cleaned01(contactInfoFromEditForm.getMobile()));
    assertEquals(cleaned01(contactDetailsForm.getWork()), cleaned01(contactInfoFromEditForm.getWork()));
    assertEquals(cleaned01(contactDetailsForm.getFax()), cleaned01(contactInfoFromEditForm.getFax()));

    assertEquals(contactDetailsForm.getEmail2(), contactInfoFromEditForm.getEmail2());
    assertEquals(contactDetailsForm.getHomepage(), contactInfoFromEditForm.getHomepage());
    assertEquals(cleaned01(contactDetailsForm.getPhone2()), cleaned01(contactInfoFromEditForm.getPhone2()));
    assertEquals(contactDetailsForm.getNotes(), contactInfoFromEditForm.getNotes());

    //assertEquals(cleaned02(contactDetailsForm.getEmail()), contactInfoFromEditForm.getEmail());
   // assertEquals(cleaned02(contactDetailsForm.getEmail3()),contactInfoFromEditForm.getEmail3());

  }

  public static String cleaned01(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-:HMWFP]", "");
  }

  public static String cleaned02(String email) {
    return email.replaceAll("[(-)]","");
  }

  private String mergeNames(ContactData contact) {
    return  Arrays.asList(contact.getFname(),contact.getMname(),contact.getLname())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining(" "));

  }

}
