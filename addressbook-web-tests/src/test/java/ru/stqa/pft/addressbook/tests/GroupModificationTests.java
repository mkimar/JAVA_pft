package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupsHelper().getGroupCount();
    if (!app.getGroupsHelper().isThereAGroup()) {
      app.getGroupsHelper().creatGroup(new GroupData("Test01", "rewa14032016", "rewa2"));
    }
    app.getGroupsHelper().selectGroup(before - 1);
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("TestNULL", null, "as_03"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGroupPage();
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }

}
