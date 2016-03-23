package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("lastname"), contactData.getLname());
    type(By.name("firstname"), contactData.getFname());
    type(By.name("middlename"), contactData.getMname());
    type(By.name("nickname"), contactData.getNickname());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void newContactCreationPage() {
    click(By.linkText("add new"));
  }

  public void contactsPage() {
    click(By.linkText("home"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteContact() {
    click(By.xpath("//input[@value=\"Delete\"]"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt=\"Edit\"]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void allertDeletionContact() {
    wd.switchTo().alert().accept();

  }

  public void create(ContactData contactData, boolean creation) {
    newContactCreationPage();
    fillContactForm(contactData, creation);
    submitContactForm();
  }

  public void modify(ContactData contact) {
    contactsPage();
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    contactsPage();
  }

  public void delete(ContactData contact) {
    contactsPage();
    selectContactById(contact.getId());
    deleteContact();
    allertDeletionContact();
    contactsPage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactsCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      String lname = element.getText();
      String fname = element.getText();
      String mname = element.getText();
      Integer id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withLname(lname).withFname(fname).withMname(mname));
    }
    return contacts;
  }


}

