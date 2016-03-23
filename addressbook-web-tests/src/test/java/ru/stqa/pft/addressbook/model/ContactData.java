package ru.stqa.pft.addressbook.model;


public class ContactData {
  private int id;
  private final String lname;
  private final String fname;
  private final String mname;
  private final String nickname;
  private final String group;

  public ContactData(String lname, String fname, String mname, String nickname, String group) {
    this.id = Integer.MAX_VALUE;
    this.lname = lname;
    this.fname = fname;
    this.mname = mname;
    this.nickname = nickname;
    this.group = group;
  }


  public ContactData(int id, String lname, String fname, String mname, String nickname, String group) {
    this.id = id;
    this.lname = lname;
    this.fname = fname;
    this.mname = mname;
    this.nickname = nickname;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
