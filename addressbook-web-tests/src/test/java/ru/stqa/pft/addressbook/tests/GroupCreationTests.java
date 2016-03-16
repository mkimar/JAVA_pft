package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupsHelper().getGroupCount();
    app.getGroupsHelper().creatGroup(new GroupData("Test04", "rewa14032016", "rewa2"));
    int after = app.getGroupsHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);



  }

}
