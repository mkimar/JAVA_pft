package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by marina on 29.02.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFname());
    type(By.name("middlename"), contactData.getMname());
    type(By.name("lastname"), contactData.getLname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAdress1());
    type(By.name("home"), contactData.getDomtel());
    type(By.name("mobile"), contactData.getMobiltel());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("address2"), contactData.getAdress2());
  }

  public void newContactCreationPage() {
    click(By.linkText("add new"));
  }

  public void allContacts() {
    click(By.xpath("//div[@id='nav']//a[text()=\"home\"]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
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
}
