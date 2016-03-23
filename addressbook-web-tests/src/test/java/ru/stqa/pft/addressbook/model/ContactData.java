package ru.stqa.pft.addressbook.model;


public class ContactData {
  private int id= Integer.MAX_VALUE;
  private String lname;
  private String fname;
  private String mname;
  private String nickname;
  private String group;

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


  @Override
  public String toString() {
    return "ContactData{" +
            "lname='" + lname + '\'' +
            ", fname='" + fname + '\'' +
            ", mname='" + mname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    return mname != null ? mname.equals(that.mname) : that.mname == null;

  }

  @Override
  public int hashCode() {
    int result = lname != null ? lname.hashCode() : 0;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (mname != null ? mname.hashCode() : 0);
    return result;
  }
}
