package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFname());
    type(By.name("lastname"), contactData.getLname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    attach(By.name("photo"), contactData.getPhoto());
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

  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  private void initContactDetailsById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();
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
    contactCache = null;
  }

  public void modify(ContactData contact) {
    contactsPage();
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    contactsPage();
  }

  public void delete(ContactData contact) {
    contactsPage();
    selectContactById(contact.getId());
    deleteContact();
    allertDeletionContact();
    contactCache = null;
    contactsPage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lname = cells.get(1).getText();
      String fname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allphones = cells.get(5).getText();
      String[] emails = cells.get(4).getText().split("\n");
      //String allemails = cells.get(4).getText();

      contactCache.add(new ContactData().withId(id).withLname(lname).withFname(fname)
              .withAllHomePhones(allphones)
              //.withEmail(emails[0]).withEmail2(emails[1]).withEmail3(emails[2])//при создании,удалении и модификации контакта это надо отключить
              .withAddress(address));
    }
    return new Contacts(contactCache);
  }

  public ContactData contactInfoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String fname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lname = wd.findElement(By.name("lastname")).getAttribute("value");
    String mname = wd.findElement(By.name("middlename")).getAttribute("value");
    String nname = wd.findElement(By.name("nickname")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getText();
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFname(fname).withLname(lname).withMname(mname).withNickname(nname).withTitle(title).withCompany(company)
            .withAddress(address).withHomePhone(home).withMobile(mobile).withWork(work).withFax(fax)
            .withEmail(email).withEmail2(email2).withEmail3(email3).withHomepage(homepage)
            .withAddress2(address2).withPhone2(phone2).withNotes(notes);

  }

  public ContactData contactDetailsForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    List<WebElement> cells = wd.findElements(By.xpath("//div[@id='content']"));
    String [] allname = cells.get(0).getText().split("\n");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFname(allname[0])
            .withNickname(allname[1]).withTitle(allname[3]).withCompany(allname[4]).withAddress(allname[5])
            .withHomePhone(allname[7]).withMobile(allname[8]).withWork(allname[9]).withFax(allname[10])
            .withEmail(allname[12]).withEmail2(allname[13]).withEmail3(allname[14])
            .withHomepage(allname[16]).withAddress2(allname[21]).withPhone2(allname[23]).withNotes(allname[25]);

  }

  public Contacts all01() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

      contactCache.add(new ContactData().withId(id));
    }
    return new Contacts(contactCache);
  }

}

