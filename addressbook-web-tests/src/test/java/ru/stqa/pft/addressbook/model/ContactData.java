package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String id;
  private final String fname;
  private final String mname;
  private final String lname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String adress1;
  private final String domtel;
  private final String mobiltel;
  private final String work;
  private final String fax;
  private final String email2;
  private final String adress2;
  private final String group;

  public ContactData(String fname, String mname, String lname, String nickname, String title, String company,
                     String adress1, String domtel, String mobiltel, String work, String fax,
                     String email2, String adress2, String group) {
    this.id = null;
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.adress1 = adress1;
    this.domtel = domtel;
    this.mobiltel = mobiltel;
    this.work = work;
    this.fax = fax;
    this.email2 = email2;
    this.adress2 = adress2;
    this.group = group;
  }

  public ContactData(String id, String fname, String mname, String lname, String nickname, String title, String company,
                     String adress1, String domtel, String mobiltel, String work, String fax,
                     String email2, String adress2, String group) {
    this.id = id;
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.adress1 = adress1;
    this.domtel = domtel;
    this.mobiltel = mobiltel;
    this.work = work;
    this.fax = fax;
    this.email2 = email2;
    this.adress2 = adress2;
    this.group = group;
  }

  public String getId() {
    return id;
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

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAdress1() {
    return adress1;
  }

  public String getDomtel() {
    return domtel;
  }

  public String getMobiltel() {
    return mobiltel;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail2() {
    return email2;
  }

  public String getAdress2() {
    return adress2;
  }

  public String getGroup() {
    return group;
  }



  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", fname='" + fname + '\'' +
            ", mname='" + mname + '\'' +
            ", lname='" + lname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    if (mname != null ? !mname.equals(that.mname) : that.mname != null) return false;
    return lname != null ? lname.equals(that.lname) : that.lname == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (mname != null ? mname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    return result;
  }
}
