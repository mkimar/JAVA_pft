package ru.stqa.pft.addressbook.model;


public class ContactData {
  private int id= Integer.MAX_VALUE;
  private String lname;
  private String fname;
  private String mname;
  private String nickname;
  private String group;
  private String home;
  private String mobile;
  private String work;
  private String email;
  private String email2;
  private String email3;
  private String address;


  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withLname(String lname) {
    this.lname = lname;
    return this;
  }

  public ContactData withFname(String fname) {
    this.fname = fname;
    return this;
  }

  public ContactData withMname(String mname) {
    this.mname = mname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2 (String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAddress (String address) {
    this.address = address;
    return this;
  }

  public String getFname() {
    return fname;
  }

  public String getMname() {
    return mname;
  }

  public String getLname() {
    return lname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getGroup() {
    return group;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lname='" + lname + '\'' +
            ", fname='" + fname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    return fname != null ? fname.equals(that.fname) : that.fname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    return result;
  }



}
