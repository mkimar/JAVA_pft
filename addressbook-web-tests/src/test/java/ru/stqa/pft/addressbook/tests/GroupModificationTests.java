package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test

  public void testGroupModification () {

    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupsHelper().isThereAGroup()){
      app.getGroupsHelper().creatGroup(new GroupData("TestNULL", "rewa14032016", "rewa2"));
    }
    app.getGroupsHelper().selectGroup();
    app.getGroupsHelper().initGroupModification();
    app.getGroupsHelper().fillGroupForm(new GroupData("TestNU", null, "as_03"));
    app.getGroupsHelper().submitGroupModification();
    app.getGroupsHelper().returnToGroupPage();
  }

}
