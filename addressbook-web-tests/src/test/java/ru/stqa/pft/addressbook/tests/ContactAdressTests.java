package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdressTests extends TestBase {

  @Test

  public void testContactAdress() {

    app.contact().contactsPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(contact);
    assertThat(contact.getFname(), equalTo(contactInfoFromEditForm.getFname()));
    assertThat(contact.getLname(), equalTo(contactInfoFromEditForm.getLname()));
    assertThat(contact.getFname(), equalTo(contactInfoFromEditForm.getFname()));
    assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
    assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));

    //assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    //}

    //private String mergeEmails(ContactData contact) {
    //return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
    //       .stream().filter((s) -> s.equals(""))
    //        .collect(Collectors.joining("\n"));
    //}

  }
}
